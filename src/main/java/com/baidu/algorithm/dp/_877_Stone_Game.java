/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _877_Stone_Game
 *
 * @author xuhaoran01
 */
public class _877_Stone_Game {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int k = 1; k < n; k++) {
            for (int i = 1; i + k <= n; i++) {
                int j = i + k;
                if ((i + j) % 2 == 1) {
                    dp[i][j] = Math.max(piles[i - 1] + dp[i + 1][j], piles[j - 1] + dp[i][j - 1]);
                } else {
                    dp[i][j] = Math.min(-piles[i - 1] + dp[i + 1][j], -piles[j - 1] + dp[i][j - 1]);
                }
            }
        }

        return dp[1][n] > 0;
    }
}
