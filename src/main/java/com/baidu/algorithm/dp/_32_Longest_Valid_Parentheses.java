/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _32_Longest_Valid_Parentheses
 *
 * @author xuhaoran01
 */
public class _32_Longest_Valid_Parentheses {

    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int len = s.length(), rs = 0;
        int[] dp = new int[len + 1];

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i + 1] = 2 + dp[i - 1];
                } else if (i - dp[i] - 1 >= 0 && s.charAt(i - dp[i] - 1) == '(') {
                    dp[i + 1] = dp[i] + 2 + dp[i - dp[i] - 1];
                }
            }

            rs = Math.max(rs, dp[i + 1]);
        }

        return rs;
    }

    public static void main(String[] args) {
        new _32_Longest_Valid_Parentheses().longestValidParentheses("(()");
    }
}
