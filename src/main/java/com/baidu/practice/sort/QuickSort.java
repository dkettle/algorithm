/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.sort;

import com.baidu.algorithm.sort.Sort;

import java.util.*;

/**
 * QuickSort
 *
 * @author xuhaoran01
 */
public class QuickSort {

    public void sort(List<Integer> nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = nums.get(start);
        int i = start + 1, j = end;
        while (i <= j) {
            if (nums.get(i) < pivot) {
                nums.set(i - 1, nums.get(i));
                i++;
            } else {
                Collections.swap(nums, i, j);
                j--;
            }
        }
        nums.set(j, pivot);

        sort(nums, start, j - 1);
        sort(nums, j + 1, end);
    }

    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return;
        }

        sort(nums, 0, nums.size() - 1);
    }

    public static void main(String[] args) {

        Random rand = new Random();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(rand.nextInt(100));
        }

        System.out.println(nums);

        new QuickSort().sort(nums);

        System.out.println(nums);
    }
}
