/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.redis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ZParams;

/**
 * chapter01
 *
 * @author xuhaoran01
 */
public class chapter01 {

    private static final int ONE_WEEK_IN_SECONDS = 7 * 86400;
    private static final int VOTE_SCORE = 432;
    private static final int ARTICLES_PER_PAGE = 25;

    private static final String Z_TIME = "time:";
    private static final String Z_SCORE = "score:";
    private static final String S_VOTE_PREFIX = "voted:";
    private static final String S_GROUP_PREFIX = "group:";
    private static final String H_ARTICLE_PREFIX = "article:";

    public static void main(String[] args) {

        new chapter01().run();
    }

    private void run() {

        Jedis conn = new Jedis("localhost", 6379);
        conn.select(15);

        String articleId = postArticle(conn, "user1", "title", "www.baidu.com");
        System.out.println("We posted a new article with id: " + articleId);
        printArticles(Arrays.asList(conn.hgetAll(H_ARTICLE_PREFIX + articleId)));

        System.out.println();

        voteArticle(conn, "user2", H_ARTICLE_PREFIX + articleId);
        printArticles(Arrays.asList(conn.hgetAll(H_ARTICLE_PREFIX + articleId)));

        System.out.println();

        printArticles(getArticles(conn, 1));

        addGroups(conn, articleId, new String[] {"group1"}, new String[]{"group2"});
        printArticles(getGroupArticles(conn, "group1", 1));
        System.out.println();

        printArticles(getGroupArticles(conn, "group2", 1));
    }

    private String postArticle(Jedis conn, String user, String title, String link) {

        String articleId = String.valueOf(conn.incr("article:"));

        String voted = S_VOTE_PREFIX + articleId;
        conn.sadd(voted, user);
        conn.expire(voted, ONE_WEEK_IN_SECONDS);

        long now = System.currentTimeMillis() / 1000;
        String article = H_ARTICLE_PREFIX + articleId;

        Map<String, String> articleData = new HashMap<>();
        articleData.put("id", articleId);
        articleData.put("user", user);
        articleData.put("title", title);
        articleData.put("link", link);
        articleData.put("time", String.valueOf(now));
        articleData.put("votes", "1");

        conn.hmset(article, articleData);
        conn.zadd(Z_TIME, now, article);
        conn.zadd(Z_SCORE, now + VOTE_SCORE, article);

        return articleId;
    }

    private void voteArticle(Jedis conn, String user, String article) {

        long cutoff = System.currentTimeMillis() / 1000 - ONE_WEEK_IN_SECONDS;
        if (conn.zscore(Z_TIME, article) < cutoff) {
            return;
        }

        String articleId = article.substring(article.indexOf(':') + 1);
        if (conn.sadd(S_VOTE_PREFIX + articleId, user) == 1) {
            conn.zincrby(Z_SCORE, VOTE_SCORE, article);
            conn.hincrBy(article, "votes", 1);
        }
    }

    private List<Map<String, String>> getArticles(Jedis conn, int page) {
        return getArticles(conn, page, Z_SCORE);
    }

    private List<Map<String, String>> getArticles(Jedis conn, int page, String order) {

        List<Map<String, String>> articles = new ArrayList<>();

        int start = (page - 1) * ARTICLES_PER_PAGE;
        int end = start + ARTICLES_PER_PAGE - 1;

        Set<String> ids = conn.zrevrange(order, start, end);
        ids.stream().forEach(id -> {
            Map<String, String> articleData = conn.hgetAll(id);

            articles.add(articleData);
        });

        return articles;
    }

    private void addGroups(Jedis conn, String articleId, String[] toAdd, String[] toRemove) {

        String article = H_ARTICLE_PREFIX + articleId;
        for (String groupId : toAdd) {
            conn.sadd(S_GROUP_PREFIX + groupId, article);
        }

        for (String groupId : toRemove) {
            conn.srem(S_GROUP_PREFIX + groupId, article);
        }
    }

    private List<Map<String, String>> getGroupArticles(Jedis conn, String group, int page) {

        return getGroupArticles(conn, group, page, Z_SCORE);
    }

    private List<Map<String, String>> getGroupArticles(Jedis conn, String group, int page, String order) {

        String key = order + group;
        if (!conn.exists(key)) {
            ZParams params = new ZParams().aggregate(ZParams.Aggregate.MAX);
            conn.zinterstore(key, params, S_GROUP_PREFIX + group, order);
            conn.expire(key, 60);
        }

        return getArticles(conn, page, key);
    }

    private void printArticles(List<Map<String, String>> articles) {

        System.out.println("total " + articles.size() + " articles.");
        articles.stream().forEach(article -> {
            System.out.println("article id: " + article.get("id"));

            article.entrySet().stream().forEach(entry -> {
                if (!entry.getKey().equals("id")) {
                    System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
                }
            });
        });
    }
}
