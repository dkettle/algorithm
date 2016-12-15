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

import com.baidu.algorithm.Pair;

/**
 * Twitter
 *
 * @author xuhaoran01
 */
public class Twitter {

    // user, follow
    private Map<Integer, Set<Integer>> followMap = new HashMap<>();

    // user, tweets
    private Map<Integer, LinkedList<Pair<Integer, Long>>> tweetMap = new HashMap<>();

    private long tweetCnts = 0;

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {

        LinkedList<Pair<Integer, Long>> userTweets = tweetMap.getOrDefault(userId, new LinkedList<>());
        userTweets.offer(new Pair<>(tweetId, tweetCnts++));
        if (userTweets.size() > 10) {
            userTweets.poll();
        }

        tweetMap.put(userId, userTweets);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Pair<Integer, Long>> pq = new PriorityQueue<>((x, y) -> (int)(y.getValue() - x.getValue()));
        Set<Integer> follows = followMap.getOrDefault(userId, new HashSet<>());
        follows.add(userId);

        follows.stream().forEach(x -> tweetMap.getOrDefault(x, new LinkedList<>()).stream().forEach(pq::add));

        List<Integer> res = new ArrayList<>(10);

        while (res.size() < 10 && !pq.isEmpty()) {
            res.add(pq.poll().getKey());
        }

        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

        Set<Integer> userFollow = followMap.getOrDefault(followerId, new HashSet<>());
        userFollow.add(followeeId);

        followMap.put(followerId, userFollow);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {

        Set<Integer> userFollow = followMap.getOrDefault(followerId, new HashSet<>());
        userFollow.remove(followeeId);

        followMap.put(followerId, userFollow);
    }
}
