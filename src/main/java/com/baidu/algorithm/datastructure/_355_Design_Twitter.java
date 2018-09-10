/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * _355_Design_Twitter
 *
 * @author xuhaoran01
 */
public class _355_Design_Twitter {


}

class Twitter {

    private Map<Integer, User> userMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }

        userMap.get(userId).postTweet(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {

        if (!userMap.containsKey(userId)) {
            return new ArrayList<>();
        }

        return userMap.get(userId).getNewsFeed();
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }

        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }

        userMap.get(followerId).follow(userMap.get(followeeId));
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }

        userMap.get(followerId).unfollow(userMap.get(followeeId));
    }
}

class Twit {
    private static int time = 0;

    public int id;
    public int pubTime;
    public Twit next;

    public Twit(int id) {
        this.id = id;
        pubTime = time++;
        next = null;
    }
}

class User {
    public int id;
    public Twit twit;
    public Set<User> follower;

    public User(int id) {
        this.id = id;
        twit = null;

        follower = new HashSet<>();
        follow(this);
    }

    public void follow(User followerId) {
        follower.add(followerId);
    }

    public void unfollow(User followerId) {
        follower.remove(followerId);
    }

    public void postTweet(int tweetId) {
        Twit t = new Twit(tweetId);
        t.next = twit;
        twit = t;
    }

    public List<Integer> getNewsFeed() {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<Twit> queue = new PriorityQueue<>((x, y) -> y.pubTime - x.pubTime);
        for (User u : follower) {
            if (u.twit != null) {
                queue.add(u.twit);
            }
        }

        while (!queue.isEmpty() && res.size() < 10) {
            Twit t = queue.remove();
            res.add(t.id);

            if (t.next != null) {
                queue.add(t.next);
            }
        }

        return res;
    }
}
