/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _213_House_Robber_II
 *
 * @author xuhaoran01
 */
public class _213_House_Robber_II {

    private int rob(int[] nums, int start, int end) {

        int first = 0, second = nums[start];
        for (int i = start + 1; i <= end; i++) {
            int cur = Integer.max(first + nums[i], second);
            first = second;
            second = cur;
        }

        return second;
    }

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        else if (nums.length == 1){
            return nums[0];
        }

        return Integer.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}
