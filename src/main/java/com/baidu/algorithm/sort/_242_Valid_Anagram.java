/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.Arrays;

/**
 * _242_Valid_Anagram
 *
 * @author xuhaoran01
 */
public class _242_Valid_Anagram {

    private String sortString(String s) {

        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }
    // sort
    public boolean isAnagram(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        return sortString(s).equals(sortString(t));
    }
;
    // bit count
    public boolean isAnagram1(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if(--count[index] < 0) {
                return false;
            }
        }

        return true;
    }
}
