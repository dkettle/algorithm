/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _123_Best_Time_to_Buy_and_Sell_Stock_III
 *
 * @author xuhaoran01
 */
public class _123_Best_Time_to_Buy_and_Sell_Stock_III {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length, res = 0, leftMin = prices[0], rightMax = prices[n - 1];
        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];

        for(int i = 1; i < n; i++) {
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - leftMin);
            leftMin = Math.min(leftMin, prices[i]);
        }

        for(int i = n - 2; i >= 0; i--) {
            rightProfit[i] = Math.max(rightProfit[i + 1], rightMax - prices[i]);
            rightMax = Math.max(rightMax, prices[i]);
        }

        for(int i = 0; i < n; i++) {
            res = Math.max(res, leftProfit[i] + rightProfit[i]);
        }

        return res;
    }
}
