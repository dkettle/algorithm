/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

/**
 * _355_Design_Twitter
 *
 * @author xuhaoran01
 */
public class _355_Design_Twitter {

    public static void main(String[] args) {

        Twitter twitter = new Twitter();

        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.getNewsFeed(1);
    }
}
