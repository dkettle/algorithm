/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _132_Palindrome_Partitioning_II
 *
 * @author xuhaoran01
 */
public class _132_Palindrome_Partitioning_II {
    public int minCut(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }

        int[] cut = new int[n];
        for(int i = 1; i < n; i++) {
            cut[i] = i + 1;
            for(int j = i; j >= 0; j--) {
                if(dp[j][i]) {
                    cut[i] = Math.min(j == 0 ? 0 : cut[j - 1] + 1, cut[i]);
                }
            }
        }

        return cut[n - 1];
    }

    public static void main(String[] args) {
        new _132_Palindrome_Partitioning_II().minCut("aab");
    }
}
