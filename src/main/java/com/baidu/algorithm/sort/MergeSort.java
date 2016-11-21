/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * MergeSort
 *
 * @author xuhaoran01
 */
public class MergeSort implements Sort {
    // O(n)的空间复杂度, 若要O(1)的空间复杂度, 则利用插入排序将右半部分插入即可
    //
    public void sort(List<Integer> nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) >> 1;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);

        List<Integer> tmp = new ArrayList<>();

        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums.get(i) <= nums.get(j)) {
                tmp.add(nums.get(i));
                i++;
            } else {
                tmp.add(nums.get(j));
                j++;
            }
        }

        while (i <= mid) {
            tmp.add(nums.get(i));
            i++;
        }

        while (j <= right) {
            tmp.add(nums.get(j));
            j++;
        }

        for (i = left; i <= right; i++) {
            nums.set(i, tmp.get(i - left));
        }
    }

    @Override
    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }

        sort(nums, 0, nums.size() - 1);
    }

}
