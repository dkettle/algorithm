/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

/**
 * _75_Sort_Colors
 *
 * @author xuhaoran01
 */
public class _75_Sort_Colors {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void sortColors(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        int u = 0, v = nums.length - 1, i = 0;
        while (i <= v) {
            if (nums[i] == 0) {
                swap(nums, i, u);
                i++;
                u++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, v);
                v--;
            }
        }
    }
}
