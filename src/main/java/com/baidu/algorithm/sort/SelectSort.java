/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.Collections;
import java.util.List;

import com.baidu.algorithm.Utils;

/**
 * SelectSort
 *
 * @author xuhaoran01
 */
public class SelectSort implements Sort {

    @Override
    public void sort(List<Integer> nums) {

        if (nums == null || nums.size() <= 1) {
            return;
        }

        for (int i = 0; i < nums.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(j) < nums.get(index)) {
                    index = j;
                }
            }

            Collections.swap(nums, i, index);
        }
    }
}
