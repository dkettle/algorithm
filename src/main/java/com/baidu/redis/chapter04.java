/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.redis;

import java.util.List;

import com.sun.org.apache.xpath.internal.FoundIndex;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * chapter04
 *
 * @author xuhaoran01
 */
public class chapter04 {

    private static final String S_INVENTORY_PREFIX = "inventory:";
    private static final String Z_MARKET = "market:";
    private static final String H_USER_PREFIX = "user:";

    public static void main(String[] args) {

        new chapter04().run();
    }

    public void run() {

        Jedis conn = new Jedis("localhost");
        conn.select(15);

        testListItem(conn);
        testPurchaseItem(conn);
    }

    public void testListItem(Jedis conn) {

        System.out.println("\n-----------testListItem-----------");
        String user = "userX";
        String item = "itemX";

        conn.sadd(S_INVENTORY_PREFIX + user, item);

        System.out.println("The user inventory has: ");
        conn.smembers(S_INVENTORY_PREFIX + user).stream().forEach(System.out::print);

        boolean success = listItem(conn, user, item, 10);
        assert success;

        conn.zrangeWithScores(Z_MARKET, 0, -1).stream()
                .forEach(x -> System.out.println('\n' + x.getElement() +": " + x.getScore()));
    }

    public void testPurchaseItem(Jedis conn) {
        System.out.println("\n---------testPurchaseItem-----------");
        conn.hset(H_USER_PREFIX + "userY", "funds", "125");

        purchaseItem(conn, "userY", "userX", "itemX");

        conn.hgetAll(H_USER_PREFIX + "userY").entrySet().stream().forEach(System.out::println);
    }

    public boolean listItem(Jedis conn, String user, String item, double price) {

        String inventory = S_INVENTORY_PREFIX + user;
        String marketItem = item + "." + user;

        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
            conn.watch(inventory);

            if (!conn.sismember(inventory, item)) {
                conn.unwatch();
                return false;
            }

            Transaction trans = conn.multi();
            trans.zadd(Z_MARKET, price, marketItem);
            trans.srem(inventory, item);

            if (trans.exec() == null) {
                continue;
            }

            return true;
        }

        return false;
    }

    public boolean purchaseItem(Jedis conn, String buyerId, String sellerId, String itemId) {

        String buyer = H_USER_PREFIX + buyerId;
        String seller = H_USER_PREFIX + sellerId;
        String item = itemId + "." + sellerId;
        String inventory = S_INVENTORY_PREFIX + buyerId;

        long end = System.currentTimeMillis() + 10000;

        while (System.currentTimeMillis() < end) {
            conn.watch(Z_MARKET, buyer);

            double price = conn.zscore(Z_MARKET, item);
            double funds = Double.parseDouble(conn.hget(buyer, "funds"));
            if (price > funds) {
                conn.unwatch();
                return false;
            }

            Transaction trans = conn.multi();
            trans.hincrByFloat(seller, "funds", price);
            trans.hincrByFloat(buyer, "funds", -price);
            trans.zrem(Z_MARKET, item);
            trans.sadd(inventory, itemId);

            if (trans.exec() != null) {
                return true;
            }
        }

        return false;
    }
}
