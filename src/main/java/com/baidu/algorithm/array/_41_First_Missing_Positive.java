/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

import java.util.Collections;

/**
 * _41_First_Missing_Positive
 *
 * @author xuhaoran01
 */
public class _41_First_Missing_Positive {

    private void swap(int[] num, int x, int y) {

        int temp = num[x];
        num[x] = num[y];
        num[y] = temp;
    }

    public int firstMissingPositive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        new _41_First_Missing_Positive().firstMissingPositive(new int[]{3, 4, -1, 1});
    }
}
