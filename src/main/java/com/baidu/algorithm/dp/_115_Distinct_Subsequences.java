/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _115_Distinct_Subsequences
 *
 * @author xuhaoran01
 */
public class _115_Distinct_Subsequences {

    public int numDistinct(String t, String s) {

        if (s == null || t == null) {
            return 0;
        }

        int sLen = s.length(), tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];

        for (int i = 0; i <= tLen; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {

                dp[i][j] = dp[i][j - 1];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[sLen][tLen];
    }
}
