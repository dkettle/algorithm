/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _121_Best_Time_to_Buy_and_Sell_Stock
 *
 * @author xuhaoran01
 */
public class _121_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int leftMin = prices[0], res = 0;
        for(int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - leftMin);
            leftMin = Math.min(leftMin, prices[i]);
        }

        return res;
    }
}
