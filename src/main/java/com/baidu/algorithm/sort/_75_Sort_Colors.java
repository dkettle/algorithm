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

    public void sortColors(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        int u = 0, v = nums.length - 1, i = 0;
        while (i <= v) {
            if (nums[i] == 0) {
                if (i > u) {
                    nums[u] = 0;
                    nums[i] = 1;
                }
                i++;
                u++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                if (i < v) {
                    nums[i] = nums[v];
                    nums[v] = 2;
                }
                v--;
            }
        }
    }
}
