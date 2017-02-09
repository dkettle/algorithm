/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _268_Missing_Number
 *
 * @author xuhaoran01
 */
public class _268_Missing_Number {

    private void swap(int[] num, int x, int y) {

        int temp = num[x];
        num[x] = num[y];
        num[y] = temp;
    }

    public int missingNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; ) {
            if (nums[i] != i && nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            }
            else {
                i++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }

        return nums.length;
    }
}
