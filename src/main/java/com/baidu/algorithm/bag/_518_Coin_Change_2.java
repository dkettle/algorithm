/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bag;

/**
 * _518_Coin_Change_2
 *
 * @author xuhaoran01
 */
public class _518_Coin_Change_2 {

    public int change(int amount, int[] coins) {
        if (coins == null) {
            return -1;
        }

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][amount];
    }
}
