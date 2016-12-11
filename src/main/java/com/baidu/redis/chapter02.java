/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;

import redis.clients.jedis.Jedis;

/**
 * chapter02
 *
 * @author xuhaoran01
 */
public class chapter02 {

    private static final String H_LOGIN = "login:";
    private static final String H_CART_PREFIX = "cart:";
    private static final String Z_RECENT = "recent:";
    private static final String Z_VIEWED_PREFIX = "viewed:";

    public static void main(String[] args) throws InterruptedException {

        new chapter02().run();
    }

    private void run() throws InterruptedException {

        Jedis conn = new Jedis("localhost");
        conn.select(15);

        testLoginCookies(conn);
        testShoppingCartCookies(conn);
    }

    private void testLoginCookies(Jedis conn) throws InterruptedException {

        System.out.println("\n--------testLoginCookies-----------");
        String token = UUID.randomUUID().toString();

        updateToken(conn, token, "hrxu", "item1");
        System.out.println("We just logged-in/update token: " + token);
        System.out.println("For user: 'hrxu'");
        System.out.println();

        System.out.println("What username do we get when we look-up that token?");
        String r = checkToken(conn, token);
        System.out.println(r);
        System.out.println();

        assert r != null;

        System.out.println("Let's drop the maximum number od cookies to 0 to clean them out");
        System.out.println("We will start a thread to do the cleaning, while we stop it later");

        CleanSessionsThread thread = new CleanSessionsThread(0);
        thread.start();
        Thread.sleep(1000);
        thread.quit();
        Thread.sleep(2000);
        if (thread.isAlive()) {
            throw new RuntimeException("The clean sessions thread is still alive?");
        }

        long s = conn.hlen(H_LOGIN);
        System.out.println("The current number of sessions still available is: " + s);
        assert s == 0;
    }

    private String checkToken(Jedis conn, String token) {

        return conn.hget(H_LOGIN, token);
    }

    private void updateToken(Jedis conn, String token, String user, String item) {

        long now = System.currentTimeMillis() / 1000;
        conn.hset(H_LOGIN, token, user);
        conn.zadd(Z_RECENT, now, token);

        if (item != null) {
            conn.zadd(Z_VIEWED_PREFIX + token, now, item);
            conn.zremrangeByRank(Z_VIEWED_PREFIX + token, 0, -26);
        }
    }

    public class CleanSessionsThread extends Thread {

        private Jedis conn;
        private int limit;
        private boolean quit;

        public CleanSessionsThread(int limit) {

            this.conn = new Jedis("localhost");
            this.conn.select(15);
            this.limit = limit;
        }

        public void quit() {

            quit = true;
        }

        public void run() {

            while (!quit) {
                long sz = conn.zcard(Z_RECENT);
                if (sz <= limit) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    continue;
                }

                long end = Math.min(sz - limit, 100);
                Set<String> tokenSet = conn.zrange(Z_RECENT, 0, end - 1);
                String[] tokens = tokenSet.toArray(new String[tokenSet.size()]);

                List<String> sessionKeys = new ArrayList<>();
                for (String token : tokens) {
                    sessionKeys.add(Z_VIEWED_PREFIX + token);
                }

                conn.del(sessionKeys.toArray(new String[sessionKeys.size()]));
                conn.hdel(H_LOGIN, tokens);
                conn.zrem(Z_RECENT, tokens);
            }
        }
    }

    private void testShoppingCartCookies(Jedis conn) throws InterruptedException {

        System.out.println("\n--------testShoppingCartCookies---------");
        String token = UUID.randomUUID().toString();

        System.out.println("We will refresh our session...");
        updateToken(conn, token, "shoppingCart", "item2");
        System.out.println("And add an item to the shopping cart");
        addToCart(conn, token, "item3", 3);

        Map<String, String> carts = conn.hgetAll(H_CART_PREFIX + token);
        System.out.println("Our shopping currently has: ");
        carts.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });

        System.out.println();

        assert carts.size() >= 1;

        System.out.println("Let's clean out our sessions and carts");
        CleanFullSessionsThread thread = new CleanFullSessionsThread(0);
        thread.start();
        Thread.sleep(1000);
        thread.quit();
        Thread.sleep(2000);
        if (thread.isAlive()) {
            throw new RuntimeException("The clean sessions thread is still alive");
        }

        carts = conn.hgetAll(H_CART_PREFIX + token);
        System.out.println("Our shopping cart now contains: ");
        carts.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });

        assert carts.size() == 0;
    }

    private void addToCart(Jedis conn, String token, String item, int count) {

        if (count <= 0) {
            conn.hdel(H_CART_PREFIX + token, item);
        } else {
            conn.hset(H_CART_PREFIX + token, item, String.valueOf(count));
        }
    }

    public class CleanFullSessionsThread extends Thread {

        private Jedis conn;
        private int limit;
        private boolean quit;

        public CleanFullSessionsThread(int limit) {
            this.conn = new Jedis("localhost");
            this.conn.select(15);

            this.limit = limit;
        }

        public void quit() {
            quit = true;
        }

        public void run() {
            while (!quit) {
                long sz = conn.zcard(Z_RECENT);
                if (sz <= limit) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    continue;
                }

                long end = Math.min(sz - limit, 100);
                Set<String> sessionSet = conn.zrange(Z_RECENT, 0, end - 1);
                String[] sessions = sessionSet.toArray(new String[1]);

                List<String> sessionKeys = new ArrayList<>();
                for (String session : sessions) {
                    sessionKeys.add(Z_VIEWED_PREFIX + session);
                    sessionKeys.add(H_CART_PREFIX + session);
                }

                conn.del(sessionKeys.toArray(new String[1]));
                conn.hdel(H_LOGIN, sessions);
                conn.zrem(Z_RECENT, sessions);
            }
        }
    }
}
