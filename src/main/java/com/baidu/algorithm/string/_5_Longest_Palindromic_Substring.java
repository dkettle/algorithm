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

        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            sb.append(c).append('#');
        }

        sb.append('$');

        return sb.toString();
    }

    public String longestPalindrome(String str) {

        if (str == null || str.length() <= 1) {
            return str;
        }

        String s = init(str);

        int len = s.length(), maxIdx = 0, maxDist = 1;
        int[] longest = new int[len];
        longest[0] = 1;

        for (int i = 1; i < len; i++) {
            int j = 1;

            if (i < maxDist) {
                j = Integer.min(maxDist - i, longest[2 * maxIdx - i]);
            }

            while (i - j >= 0 && i + j < len && s.charAt(i + j) == s.charAt(i - j)) {
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
                maxIdx = i;
                maxDist = longest[i];
            }
        }

        return str.substring((maxIdx - maxDist + 1) / 2, (maxIdx + maxDist) / 2 - 1);
    }

    public static void main(String[] args) {
        System.out.println(
                new _5_Longest_Palindromic_Substring().longestPalindrome("bb")
        );
    }
}
