/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

import java.util.Arrays;

/**
 * _462_Minimum_Moves_to_Equal_Array_Elements_II
 *
 * @author xuhaoran01
 */
public class _462_Minimum_Moves_to_Equal_Array_Elements_II {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int i = 0, j = nums.length - 1, res = 0;
        while (i < j) {
            res += nums[j] - nums[i];
            i++;
            j--;
        }

        return res;
    }
}
