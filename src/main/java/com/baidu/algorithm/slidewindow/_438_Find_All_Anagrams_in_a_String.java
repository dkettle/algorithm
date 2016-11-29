/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _438_Find_All_Anagrams_in_a_String
 *
 * @author xuhaoran01
 */
public class _438_Find_All_Anagrams_in_a_String {


    // Sliding Window
    /**
     * Basically, we are interested only when every count[i] becomes 0. We observe that:
          1.the sum of all count[i] is always >=0;
          2.count is the sum of all positive count[i];
       therefore, every count[i] is zero if and only if count is 0.
     */

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }

        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }

        int n = p.length();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (i - j == p.length()) {
                if (++count[s.charAt(j) - 'a'] >= 1) {
                    n++;
                }
                j++;
            }

            if (--count[s.charAt(i) - 'a'] >= 0) {
                n--;
            }

            if (n == 0) {
                res.add(j);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new _438_Find_All_Anagrams_in_a_String().findAnagrams("cbaebabacd", "abc");
    }
}
