/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * MgereSort
 *
 * @author xuhaoran01
 */
public class MergeSort {

    public void sort(List<Integer> nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (end - start) / 2 + start;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);

        List<Integer> rs = new ArrayList<>();
        int i = start, j = mid + 1;
        for (; i <= mid && j <= end; ) {
            if (nums.get(i) < nums.get(j)) {
                rs.add(nums.get(i));
                i++;
            } else {
                rs.add(nums.get(j));
                j++;
            }
        }

        while (i <= mid) {
            rs.add(nums.get(i));
            i++;
        }

        while (j <= end) {
            rs.add(nums.get(j));
            j++;
        }

        for (int k = start; k <= end; k++) {
            nums.set(k, rs.get(k - start));
        }
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

        new MergeSort().sort(nums);

        System.out.println(nums);

    }
}
