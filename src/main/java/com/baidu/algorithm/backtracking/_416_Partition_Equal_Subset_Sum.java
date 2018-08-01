/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * _416_Partition_Equal_Subset_Sum
 *
 * @author xuhaoran01
 */
public class _416_Partition_Equal_Subset_Sum {
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

        int n = sum / 2;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = n; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] | dp[j - nums[i - 1]];
            }
        }

        return dp[n];
    }
}
