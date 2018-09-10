/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * _324_Wiggle_Sort_II
 *
 * @author xuhaoran01
 */
public class _324_Wiggle_Sort_II {

    private int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() < num) {
                queue.remove();
                queue.add(num);
            }
        }

        return queue.peek();
    }

    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) >> 1);
        int i = 0, left = 0, right = n - 1;

        while (i <= right) {
            int ni = newIndex(i, n);
            if (nums[ni] > median) {
                swap(nums, ni, newIndex(left, n));
                i++;
                left++;
            } else if (nums[ni] < median) {
                swap(nums, ni, newIndex(right, n));
                right--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    public static void main(String[] args) {
        new _324_Wiggle_Sort_II().wiggleSort(new int[]{1, 5, 1, 1, 6, 4});

        _324_Wiggle_Sort_II wiggleSort = new _324_Wiggle_Sort_II();

        for (int i = 0; i < 6; i++) {
            System.out.println(wiggleSort.newIndex(i, 6));
        }
    }
}
