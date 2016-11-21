/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.Collections;
import java.util.List;

/**
 * ShellSort
 *
 * @author xuhaoran01
 */
public class ShellSort implements Sort {

    private void sort(List<Integer> nums, int d) {

        for (int i = d; i < nums.size(); i++) {

            int tmp = nums.get(i), j = i - d;

            for (; j >= 0; j -= d) {
                if (nums.get(j) > tmp) {
                    Collections.swap(nums, j + d, j);
                } else {
                    break;
                }
            }

            nums.set(j + d, tmp);
        }
    }

    @Override
    public void sort(List<Integer> nums) {

        if (nums == null || nums.size() <= 1) {
            return;
        }

        int d = nums.size() / 2;
        while (d >= 1) {
            sort(nums, d);
            d >>= 1;
        }
    }
}
