/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _837_New_21_Game
 *
 * @author xuhaoran01
 */
public class _837_New_21_Game {

    public double new21Game(int N, int K, int W) {
        double[] dp = new double[W + N + 1];
        for (int i = K; i <= N; i++) {
            dp[i] = 1.0;
        }

        double S = Math.min(N - K + 1, W);
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = S / W;
            S += dp[i] - dp[i + W];
        }

        return dp[0];
    }
}
