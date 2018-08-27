/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bag;

/**
 * _416_Partition_Equal_Subset_Sum
 *
 * @author xuhaoran01
 */
public class _416_Partition_Equal_Subset_Sum {
    // 01背包
    public boolean canPartition1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        sum /= 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] | dp[j - nums[i - 1]];
            }
        }

        return dp[sum];
    }
}
