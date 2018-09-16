/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _712_Minimum_ASCII_Delete_Sum_for_Two_Strings
 *
 * @author xuhaoran01
 */
public class _712_Minimum_ASCII_Delete_Sum_for_Two_Strings {

    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + (int) s1.charAt(i - 1);
        }

        for (int i = 1; i <= n2; i++) {
            dp[0][i] = dp[0][i - 1] + (int) s2.charAt(i - 1);
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                char c1 = s1.charAt(i - 1), c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + (int) c1, dp[i][j - 1] + (int) c2);
                }
            }
        }

        return dp[n1][n2];
    }
}
