/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _453_Minimum_Moves_to_Equal_Array_Elements
 *
 * @author xuhaoran01
 */
public class _453_Minimum_Moves_to_Equal_Array_Elements {

    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0, minNum = nums[0];
        for (int num : nums) {
            sum += num;
            minNum = Math.min(num, minNum);
        }

        return sum - minNum * nums.length;
    }
}
