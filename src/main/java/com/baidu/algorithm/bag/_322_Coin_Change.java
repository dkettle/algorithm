/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bag;

/**
 * _322_Coin_Change
 *
 * @author xuhaoran01
 */
public class _322_Coin_Change {
    // 完全背包
    public int coinChange1(int[] coins, int amount) {
        if (coins == null) {
            return 0;
        }

        int n = coins.length;
        long[][] dp = new long[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }


        return dp[n][amount] == Integer.MAX_VALUE ? -1 : (int) dp[n][amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return 0;
        }

        int n = coins.length;
        long[] dp = new long[amount + 1];

        for (int j = 1; j <= amount; j++) {
            dp[j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
                }
            }
        }


        return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }
}
