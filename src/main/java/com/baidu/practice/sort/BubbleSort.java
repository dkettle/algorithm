/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * BubbleSort
 *
 * @author xuhaoran01
 */
public class BubbleSort {

    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return;
        }

        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = 0; j < nums.size() - i - 1; j++) {
                if (nums.get(j) > nums.get(j + 1)) {
                    Collections.swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(rand.nextInt(100));
        }

        System.out.println(nums);

        new BubbleSort().sort(nums);

        System.out.println(nums);
    }
}
