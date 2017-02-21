/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _516_Longest_Palindromic_Subsequence
 *
 * @author xuhaoran01
 */
public class _516_Longest_Palindromic_Subsequence {

    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if (i < n - 1) {
                dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)) ? 2 : 1;
            }
        }

        for (int k = 2; k < n; k++) {
            for (int i = 0; i + k < n; i++) {
                if (s.charAt(i) == s.charAt(i + k)) {
                    dp[i][i + k] = 2 + dp[i + 1][i + k - 1];
                }
                dp[i][i + k] = Math.max(dp[i][i + k], Math.max(dp[i + 1][i + k], dp[i][i + k - 1]));
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        new _516_Longest_Palindromic_Subsequence().longestPalindromeSubseq("abcdef");
    }
}
