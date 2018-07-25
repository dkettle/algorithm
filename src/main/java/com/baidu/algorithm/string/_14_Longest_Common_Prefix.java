/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _14_Longest_Common_Prefix
 *
 * @author xuhaoran01
 */
public class _14_Longest_Common_Prefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; ; i++) {
            int j = 0;
            for (; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    break;
                }
            }
            if (j == strs.length) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        new _14_Longest_Common_Prefix().longestCommonPrefix(new String[]{"abab", "aba", "abc"});

        StringBuilder sb = new StringBuilder();
        String str = sb.toString();
        System.out.println(sb.toString());
    }
}
