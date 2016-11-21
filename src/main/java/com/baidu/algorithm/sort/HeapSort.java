/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.Collections;
import java.util.List;

/**
 * HeapSort
 *
 * @author xuhaoran01
 */
public class HeapSort implements Sort {

    // 大根堆
    //
    private static void buildHeap(List<Integer> nums) {

        int n = nums.size() - 1;

        for (int i = (n - 1) / 2; i >= 0; i--) {
            adjustHeap(nums, i, n);
        }
    }

    private static void adjustHeap(List<Integer> nums, int start, int end) {

        int j = 2 * start + 1, k = start;

        for (; j <= end; j = 2 * j + 1) {

            if (j + 1 <= end && nums.get(j) < nums.get(j + 1)) {
                j++;
            }

            if (nums.get(j) > nums.get(k)) {
                Collections.swap(nums, j, k);
                k = j;
            } else {
                break;
            }
        }
    }

    @Override
    public void sort(List<Integer> nums) {

        if (nums == null || nums.size() <= 1) {
            return;
        }

        buildHeap(nums);

        for (int i = nums.size() - 1; i > 0; i--) {
            Collections.swap(nums, 0, i);
            adjustHeap(nums, 0, i - 1);
        }
    }
}
