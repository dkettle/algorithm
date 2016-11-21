/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.Collections;
import java.util.List;

import com.baidu.algorithm.Utils;

/**
 * BubbleSort
 *
 * @author xuhaoran01
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(List<Integer> nums) {

        if (nums == null || nums.size() <= 1) {
            return;
        }

        for (int i = nums.size() - 1; i > 0; i--) {

            boolean update = false;

            for (int j = 0; j < i; j++) {

                if (nums.get(j) > nums.get(j + 1)) {

                    Collections.swap(nums, j, j + 1);

                    update = true;
                }
            }

            if (!update) {
                break;
            }
        }
    }
}
