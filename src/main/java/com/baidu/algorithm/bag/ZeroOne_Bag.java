/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bag;

/**
 * ZeroOne_Bag
 *
 * @author xuhaoran01
 */
public class ZeroOne_Bag {

    // n件物品, 容量为m
    // f[i][j] = max{f[i-1][j-a[i]] + b[i], f[i-1][j]}
    public int maxValue(int[] weights, int[] values, int n, int m) {

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    public int maxValue1(int[] weights, int[] values, int n, int m) {

        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = weights[i - 1]; j <= m; j++) {
                dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }

        return dp[m];
    }
}
