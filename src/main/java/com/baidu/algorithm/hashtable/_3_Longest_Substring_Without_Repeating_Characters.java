/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * _3_Longest_Substring_Without_Repeating_Characters
 *
 * @author xuhaoran01
 */
public class _3_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int res = 1, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= j) {
                res = Math.max(res, i - j);
                j = map.get(c) + 1;
            }

            map.put(c, i);
        }

        return Math.max(res, s.length() - j);
    }

    public static void main(String[] args) {
        new _3_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("abba");
    }
}
