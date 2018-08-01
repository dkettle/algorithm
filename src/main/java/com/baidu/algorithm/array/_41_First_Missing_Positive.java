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

    public static void main(String[] args) {
        new _41_First_Missing_Positive().firstMissingPositive(new int[]{3, 4, -1, 1});
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int n = nums.length;
        for (int i = 0; i < n; ) {
            if (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[i], j = nums[i] - 1;
                nums[i] = nums[j];
                nums[j] = tmp;
            } else {
                i++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}

