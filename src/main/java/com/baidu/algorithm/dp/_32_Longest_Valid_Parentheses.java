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

    // dp
    public int longestValidParentheses(String s) {

        if (s == null || s.length() <= 1) {
            return 0;
        }

        int len = s.length(), res = 0;
        char[] sArr = s.toCharArray();
        int[] dp = new int[len + 1];

        for (int i = len - 2; i >= 0; i--) {
            if (sArr[i] == '(' && i + 1 + dp[i + 1] < len && sArr[i + dp[i + 1] + 1] == ')') {
                dp[i] = 2 + dp[i + 1] + dp[i + dp[i + 1] + 2];
                res = Integer.max(res, dp[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new _32_Longest_Valid_Parentheses().longestValidParentheses("(()");
    }
}
