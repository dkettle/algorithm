/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _303_Range_Sum_Query_Immutable
 *
 * @author xuhaoran01
 */
public class _303_Range_Sum_Query_Immutable {

    class NumArray {

        private int[] cumSum;

        public NumArray(int[] nums) {
            int n = nums.length;

            cumSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                cumSum[i + 1] = cumSum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return cumSum[j + 1] - cumSum[i];
        }
    }

    public static void main(String[] args) {
        NumArray na = new _303_Range_Sum_Query_Immutable().new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        na.sumRange(0, 2);
        na.sumRange(2, 5);
        na.sumRange(0, 5);
    }
}
