/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.divideandconquer;

/**
 * _327_Count_of_Range_Sum
 *
 * @author xuhaoran01
 */
public class _327_Count_of_Range_Sum {
    private void mergeSortHelper(long[] sum, int begin, int end) {
        long[] newSum = new long[end - begin + 1];
        int mid = (begin + end) / 2, l = begin, r = mid + 1, k = 0;
        while (l <= mid && r <= end) {
            if (sum[l] <= sum[r]) {
                newSum[k++] = sum[l++];
            } else {
                newSum[k++] = sum[r++];
            }
        }

        while (l <= mid) {
            newSum[k++] = sum[l++];
        }

        while (r <= end) {
            newSum[k++] = sum[r++];
        }

        for (k = begin; k <= end; k++) {
            sum[k] = newSum[k - begin];
        }
    }

    private int mergeSort(long[] sum, int begin, int end, int lower, int upper) {
        int count = 0;
        if (begin < end) {
            int mid = (begin + end) / 2;
            count += mergeSort(sum, begin, mid, lower, upper) + mergeSort(sum, mid + 1, end, lower, upper);
            int i = mid + 1, j = i;
            for (int k = begin; k <= mid; k++) {
                while (i <= end && sum[i] - sum[k] < lower) {
                    i++;
                }

                while (j <= end && sum[j] - sum[k] <= upper) {
                    j++;
                }

                count += j - i;
            }

            mergeSortHelper(sum, begin, end);
        } else if (begin == end) {
            if (sum[begin] >= lower && sum[begin] <= upper) {
                count = 1;
            }
        }

        return count;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        long curSum = 0;
        long[] sum = new long[n];

        for (int i = 0; i < n; i++) {
            sum[i] = curSum + nums[i];
            curSum = sum[i];
        }

        return mergeSort(sum, 0, n - 1, lower, upper);
    }

    public static void main(String[] args) {
        new _327_Count_of_Range_Sum().countRangeSum(new int[]{-2, 5, -1}, -2, 2);
    }
}
