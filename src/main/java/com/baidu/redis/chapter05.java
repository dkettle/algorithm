/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.redis;

import java.io.File;
import java.io.FileReader;
import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TimeZone;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.tools.ant.taskdefs.optional.depend.constantpool.IntegerCPInfo;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.exceptions.JedisException;

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

    public static void main(String[] args) throws Exception {
        new chapter05().run();
    }

    public void run() throws Exception {

        Jedis conn = new Jedis("localhost");
        conn.select(15);

        conn.flushDB();

        testLogRecent(conn);
        testLogCommon(conn);

        testIpLookUp(conn);
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

    public void testIpLookUp(Jedis conn) throws Exception {

        System.out.println("\n----------testIpLookUp---------");

        String cwd = System.getProperty("user.dir");

        File blocks = new File(cwd + "/GeoLiteCity-Blocks.csv");
        if (!blocks.exists()) {
            System.out.println("GeoLiteCity-Blocks.csv not exist in: " + cwd);
        }

        File locations = new File(cwd + "/GeoLiteCity-Location.csv");
        if (!locations.exists()) {
            System.out.println("GeoLiteCity-Location.csv not exists in: " + cwd);
        }

        importIpsToRedis(conn, blocks);
        System.out.println("Loaded ranges into Redis: " + conn.zcard("ip2cityid:"));

        importCitysToRedis(conn, locations);
        System.out.println("Loaded city lookups into Redis: " + conn.hlen("cityid2city:"));

        for (int i = 0; i < 5; i++) {
            String ip = randomOctet(255) + "." +
                                randomOctet(256) + "." +
                                randomOctet(256) + "." +
                                randomOctet(256);

            System.out.println(Arrays.toString(findCityByIp(conn, ip)));
        }
    }

    public void importIpsToRedis(Jedis conn, File blocks) {

        FileReader reader = null;

        try {
            reader = new FileReader(blocks);
            CSVParser parser = CSVFormat.DEFAULT.parse(reader);

            int count = 0, index = 2;
            List<CSVRecord> records = parser.getRecords();

            while (index < records.size()) {

                String startIp = records.get(index).get(0);
                int score = 0;

                if (startIp.indexOf('.') != -1) {
                    score = ipToScore(startIp);
                } else {
                    score = Integer.parseInt(startIp, 10);
                }

                String cityId = records.get(index).get(2) + "_" + count;
                conn.zadd("ip2cityid:", score, cityId);
                count++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

            try {
                reader.close();
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
        }
    }

    public int ipToScore(String ip) throws Exception {

        int score = 0;
        for (String v : ip.split("\\.")) {
            score = (score << 8) + Integer.parseInt(v, 10);
        }

        return score;
    }

    public void importCitysToRedis(Jedis conn, File file) {

        Gson gson = new Gson();
        FileReader reader = null;

        try {
            reader = new FileReader(file);
            CSVParser parser = CSVFormat.DEFAULT.parse(reader);

            int index = 2;
            List<CSVRecord> records = parser.getRecords();
            while (index < records.size()) {

                String cityId = records.get(index).get(0);
                String country = records.get(index).get(1);
                String latitude = records.get(index).get(5);
                String longitude = records.get(index).get(6);

                String json = gson.toJson(Arrays.asList(cityId, country, latitude, longitude));
                conn.hset("cityid2city:", cityId, json);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
        }
    }

    public String randomOctet(int max) {

        return String.valueOf((int) Math.random() * max);
    }

    public String[] findCityByIp(Jedis conn, String ip) throws Exception {

        int score = ipToScore(ip);

        Set<String> results = conn.zrevrangeByScore("ip2cityid:", score, 0, 0, 1);
        if (results.size() == 0) {
            return null;
        }

        String cityId = results.iterator().next();
        cityId = cityId.substring(0, cityId.indexOf('_'));

        return new Gson().fromJson(conn.hget("cityid2city:", cityId), String[].class);
    }
}
