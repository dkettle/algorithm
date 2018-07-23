/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * InsertSort
 *
 * @author xuhaoran01
 */
public class InsertSort {

    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return;
        }

        for (int i = 1; i < nums.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums.get(j + 1) < nums.get(j)) {
                    Collections.swap(nums, j + 1, j);
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

        new InsertSort().sort(nums);

        System.out.println(nums);
    }
}
