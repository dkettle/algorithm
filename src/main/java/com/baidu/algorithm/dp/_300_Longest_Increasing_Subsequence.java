/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _300_Longest_Increasing_Subsequence
 *
 * @author xuhaoran01
 */
public class _300_Longest_Increasing_Subsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length, res = 0;
        int[] tail = new int[n];

        for (int num : nums) {
            int i = 0, j = res;
            while (i != j) {
                int mid = (i + j) >> 1;
                if (tail[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }

            tail[i] = num;
            if (i == res) {
                res++;
            }
        }

        return res;
    }
}
