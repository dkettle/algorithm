/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

/**
 * _409_Longest_Palindrome
 *
 * @author xuhaoran01
 */
public class _409_Longest_Palindrome {

    public int longestPalindrome(String s) {

        if (s == null) {
            return 0;
        }

        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int halfCount = 0;
        for (int v : count) {
            halfCount += v >> 1;
        }

        halfCount *= 2;

        return halfCount == s.length() ? halfCount : halfCount + 1;
    }
}
