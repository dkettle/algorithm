/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.divideandconquer;

/**
 * _493_Reverse_Pairs
 *
 * @author xuhaoran01
 */
public class _493_Reverse_Pairs {
    private int mergeSort(int[] nums, int begin, int end) {
        int count = 0;
        if (begin < end) {
            int mid = (begin + end) / 2;
            count += mergeSort(nums, begin, mid) + mergeSort(nums, mid + 1, end);
            int j = mid + 1;
            for (int i = begin; i <= mid; i++) {
                while (j <= end && nums[i] > 2L * nums[j]) {
                    j++;
                }

                count += j - mid - 1;
            }

            int[] tmp = new int[end - begin + 1];
            int l = begin, r = mid + 1, k = 0;
            while (l <= mid && r <= end) {
                if (nums[l] <= nums[r]) {
                    tmp[k++] = nums[l++];
                } else {
                    tmp[k++] = nums[r++];
                }
            }

            while (l <= mid) {
                tmp[k++] = nums[l++];
            }

            while (r <= end) {
                tmp[k++] = nums[r++];
            }

            for (int i = begin; i <= end; i++) {
                nums[i] = tmp[i - begin];
            }
        }

        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
