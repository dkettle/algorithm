/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * ShellSort
 *
 * @author xuhaoran01
 */
public class ShellSort {

    public void sort(List<Integer> nums, int d) {
        for (int i = d; i < nums.size(); i++) {
            for (int j = i - d; j >= 0; j -= d) {
                if (nums.get(j) > nums.get(j + d)) {
                    Collections.swap(nums, j, j + d);
                } else {
                    break;
                }
            }
        }
    }

    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return;
        }

        int d = nums.size() / 2;
        while (d > 0) {
            sort(nums, d);
            d >>= 1;
        }
    }

    public static void main(String[] args) {

        Random rand = new Random();

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(rand.nextInt(100));
        }

        System.out.println(nums);

        new ShellSort().sort(nums);

        System.out.println(nums);
    }
}
