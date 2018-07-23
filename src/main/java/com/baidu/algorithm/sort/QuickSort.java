/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.Collections;
import java.util.List;

/**
 * QuickSort
 *
 * @author xuhaoran01
 */
public class QuickSort implements Sort {

    public void sort(List<Integer> nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int pivot = nums.get(left);
        int j = left + 1, k = right;

        for ( ; j <= k; ) {

            int current = nums.get(j);

            if (current <= pivot) {
                j++;
            } else {
                Collections.swap(nums, j, k);
                k--;
            }
        }

        Collections.swap(nums, left, k);

        sort(nums, left, k - 1);
        sort(nums, k + 1, right);
    }

    @Override
    public void sort(List<Integer> nums) {

        if (nums == null || nums.size() == 0) {
            return;
        }

        sort(nums, 0, nums.size() - 1);
    }
}
