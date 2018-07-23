/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.string;

/**
 * Anagram
 *
 * @author xuhaoran01
 */
public class Anagram {

    public boolean isAnagram(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        } else if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        int[] cnt = new int[256];
        for (char c : s1.toCharArray()) {
            cnt[(int) c]++;
        }

        for (char c : s2.toCharArray()) {
            cnt[(int) c]--;
        }

        for (int v : cnt) {
            if (v != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram("abbcd", "abcdb"));
    }
}
