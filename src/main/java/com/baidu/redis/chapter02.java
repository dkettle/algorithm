/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.redis;

import redis.clients.jedis.Jedis;

/**
 * chapter02
 *
 * @author xuhaoran01
 */
public class chapter02 {

    public static void main(String[] args) throws InterruptedException {

        new chapter02().run();
    }

    private void run() throws InterruptedException {

        Jedis conn = new Jedis("localhost");
        conn.select(15);

        testLoginCookies(conn);
    }

    private void testLoginCookies(Jedis conn) throws InterruptedException {

    }
}
