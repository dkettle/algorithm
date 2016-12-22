/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.redis;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.Tuple;

/**
 * chapter05
 *
 * @author xuhaoran01
 */
public class chapter05 {

    private static final SimpleDateFormat TIMESTAMP = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
    private static final SimpleDateFormat ISO_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:00:00");
    private static final Collator COLLATOR = Collator.getInstance();

    static {
        ISO_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static void main(String[] args) throws InterruptedException {
        new chapter05().run();
    }

    public void run() throws InterruptedException {

        Jedis conn = new Jedis("localhost");
        conn.select(15);

        conn.flushDB();

        testLogRecent(conn);
        testLogCommon(conn);
    }

    public void testLogRecent(Jedis conn) {

        System.out.println("\n-----------testLogRecent-------------");
        for (int i = 0; i < 5; i++) {
            logRecent(conn, "test", "this is message" + i);
        }

        List<String> recent = conn.lrange("recent:test:info", 0, -1);

        System.out.println("current recent message has: " + recent.size());
        recent.stream().forEach(System.out::println);

        assert recent.size() >= 5;
    }

    public void logRecent(Jedis conn, String name, String message) {
        logRecent(conn, name, message, "info");
    }

    private void logRecent(Jedis conn, String name, String message, String severity) {
        String destination = "recent:" + name + ":" + severity;

        Pipeline pipe = conn.pipelined();
        pipe.lpush(destination, TIMESTAMP.format(new Date()) + ' ' + message);
        pipe.ltrim(destination, 0, 99);

        pipe.sync();
    }

    public void testLogCommon(Jedis conn) {

        System.out.println("\n--------testLogCommon---------");
        for (int count = 1; count < 6; count++) {
            for (int i = 0; i < count; i++) {
                logCommon(conn, "test", "message-" + count);
            }
        }

        Set<Tuple> common = conn.zrevrangeWithScores("common:test:info", 0, -1);

        System.out.println("current common message has: " + common.size());
        common.stream().forEach(x -> {
            System.out.println(x.getElement() + ": " + x.getScore());
        });

        assert common.size() >= 5;
    }

    private void logCommon(Jedis conn, String name, String message) {
        logCommon(conn, name, message, "info", 10);
    }

    private void logCommon(Jedis conn, String name, String message, String severity, int duration) {

        String destination = "common:" + name + ":" + severity;
        String startKey = destination + ":start";
        conn.set(startKey, ISO_FORMAT.format(new Date()));

        long end = System.currentTimeMillis() + duration;
        while (System.currentTimeMillis() < end) {
            conn.watch(startKey);
            String hourStart = ISO_FORMAT.format(new Date());
            String existing = conn.get(startKey);

            Transaction trans = conn.multi();
            if (existing != null && COLLATOR.compare(existing, hourStart) < 0) {
                trans.rename(destination, destination + ":last");
                trans.rename(startKey, startKey + ":pstart");
                trans.set(startKey, hourStart);
            }

            trans.zincrby(destination, 1, message);

            String recentDest = "recent:" + name + ":" + severity;
            trans.lpush(recentDest, TIMESTAMP.format(new Date()) + ' ' + message);
            trans.ltrim(recentDest, 0, 99);

            if (trans.exec() != null) {
                return;
            }
        }
    }
}
