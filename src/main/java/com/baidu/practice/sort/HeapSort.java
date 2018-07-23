/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * HeapSort
 *
 * @author xuhaoran01
 */
public class HeapSort {
    public void buildHead(List<Integer> nums) {
        int end = nums.size() - 1;
        for (int i = (end - 1) / 2; i >= 0; i--) {
            adjustHeap(nums, i, end);
        }
    }

    public void adjustHeap(List<Integer> nums, int start, int end) {
        for (int i = start, j = 2 * i + 1; j <= end; i = j, j = 2 * i + 1) {
            if (j + 1 <= end && nums.get(j + 1) < nums.get(j)) {
                j++;
            }

            if (nums.get(i) > nums.get(j)) {
                Collections.swap(nums, i, j);
            } else {
                break;
            }
        }
    }

    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return;
        }

        buildHead(nums);
    }

    public static void main(String[] args) {
        Random rand = new Random();

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(rand.nextInt(100));
        }

        System.out.println(nums);

        new HeapSort().sort(nums);

        System.out.println(nums);
    }
}
