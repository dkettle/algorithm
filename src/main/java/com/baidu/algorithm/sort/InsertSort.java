/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.Collections;
import java.util.List;

import com.baidu.algorithm.Utils;

/**
 * InsertSort
 *
 * @author xuhaoran01
 */
public class InsertSort implements Sort {

    @Override
    public void sort(List<Integer> nums) {

        if (nums == null || nums.size() == 0) {
            return;
        }

        int n = nums.size();
        for (int i = 1; i < n; i++) {
            int tmp = nums.get(i), j = i - 1;

            for ( ; j >= 0; j--) {
                if (nums.get(j) > tmp) {
                    Collections.swap(nums, j + 1, j);
                } else {
                    // 如果不break, 最后面一行set会有问题
                    break;
                }
            }

            nums.set(j + 1, tmp);
        }
    }
}
