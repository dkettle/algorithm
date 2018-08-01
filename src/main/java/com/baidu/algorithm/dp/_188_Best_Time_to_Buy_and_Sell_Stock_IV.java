/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _188_Best_Time_to_Buy_and_Sell_Stock_IV
 *
 * @author xuhaoran01
 */
public class _188_Best_Time_to_Buy_and_Sell_Stock_IV {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        if(k >= n / 2) {
            int res = 0;
            for(int i = 1; i < n; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }

            return res;
        }

        int[][] dp = new int[k + 1][n];
        for(int i = 1; i <= k; i++) {
            int tmp = -prices[0];
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmp);
                tmp = Math.max(tmp, dp[i - 1][j] - prices[j]);
            }
        }


        return dp[k][n - 1];
    }
}
