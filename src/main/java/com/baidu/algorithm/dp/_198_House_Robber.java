/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _198_House_Robber
 *
 * @author xuhaoran01
 */
public class _198_House_Robber {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[1] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i + 1] = Integer.max(dp[i], dp[i - 1] + nums[i]);
        }

        return dp[len];
    }
}
