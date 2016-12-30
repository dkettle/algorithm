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
        int i = left, j = i + 1, k = right;

        // 观察到i, j总是同步变化, 其实只需要一个变量就可以了
        //
        for ( ; j <= k; ) {

            int current = nums.get(j);

            if (current <= pivot) {
                nums.set(i, current);
                i++;
                j++;
            } else {
                Collections.swap(nums, j, k);
                k--;
            }
        }

        nums.set(k, pivot);

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
