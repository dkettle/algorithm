/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _565_Array_Nesting
 *
 * @author xuhaoran01
 */
public class _565_Array_Nesting {

    // O(N), O(1)s
    public int arrayNesting(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != n) {
                int count = 0, idx = i;
                while (nums[idx] != n) {
                    int t = idx;
                    idx = nums[idx];
                    nums[t] = n;
                    count++;
                }

                res = Math.max(res, count);
            }
        }

        return res;
    }
}
