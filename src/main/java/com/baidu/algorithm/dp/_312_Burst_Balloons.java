/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _312_Burst_Balloons
 *
 * @author xuhaoran01
 */
public class _312_Burst_Balloons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int k = 0; k < n; k++) {
            for (int l = 0; l + k < n; l++) {
                int r = l + k;
                for (int i = l; i <= r; i++) {
                    int coins = nums[i] * getValue(nums, l - 1) * getValue(nums, r + 1);
                    if (i > l) {
                        coins += dp[l][i - 1];
                    }
                    if (i < r) {
                        coins += dp[i + 1][r];
                    }

                    dp[l][r] = Math.max(dp[l][r], coins);
                }
            }
        }

        return dp[0][n - 1];
    }

    private int getValue(int[] nums, int idx) {
        if (idx < 0 || idx >= nums.length) {
            return 1;
        } else {
            return nums[idx];
        }
    }
}
