/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _5_Longest_Palindromic_Substring
 *
 * @author xuhaoran01
 */
public class _5_Longest_Palindromic_Substring {

    private String init(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("^#");

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }

        sb.append("$");
        return sb.toString();
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String str = init(s);
        int len = str.length(), maxIdx = 0, maxDist = 1;
        int[] longest = new int[len];
        longest[0] = 1;

        for (int i = 1; i < len; i++) {
            int j = i < maxDist ? Math.min(maxDist - i, longest[2 * maxIdx - i]) : 1;
            while (i - j >= 0 && i + j < len && str.charAt(i - j) == str.charAt(i + j)) {
                j++;
            }

            if (i + j > maxDist) {
                maxIdx = i;
                maxDist = i + j;
            }

            longest[i] = j;
        }

        maxDist = -1;
        for (int i = 0; i < len; i++) {
            if (longest[i] > maxDist) {
                maxDist = longest[i];
                maxIdx = i;
            }
        }

        return s.substring((maxIdx - maxDist) / 2, (maxIdx + maxDist - 1) / 2);
    }

    public static void main(String[] args) {
        System.out.println(
                new _5_Longest_Palindromic_Substring().longestPalindrome("babad")
        );
    }
}
