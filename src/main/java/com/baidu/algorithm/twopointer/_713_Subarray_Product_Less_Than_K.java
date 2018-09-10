/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.twopointer;

/**
 * _713_Subarray_Product_Less_Than_K
 *
 * @author xuhaoran01
 */
public class _713_Subarray_Product_Less_Than_K {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1) {
            return 0;
        }

        int res = 0;
        long prod = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            prod *= nums[j];
            while (prod >= k) {
                prod /= nums[i];
                i++;
            }

            res += j - i + 1;
        }

        return res;
    }
}
