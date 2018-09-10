/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * _215_Kth_Largest_Element_in_an_Array
 *
 * @author xuhaoran01
 */
public class _215_Kth_Largest_Element_in_an_Array {

    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int v : nums) {
            if (queue.size() < k) {
                queue.add(v);
            } else if (queue.peek() < v) {
                queue.remove();
                queue.add(v);
            }
        }

        return queue.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int findKthLargest(int[] nums, int begin, int end, int k) {
        int pivot = nums[begin], i = begin + 1, j = end;
        while (i <= j) {
            if (nums[i] <= pivot) {
                i++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, begin, j);

        if (end - j + 1 == k) {
            return pivot;
        } else if (end - j + 1 > k) {
            return findKthLargest(nums, j + 1, end, k);
        } else {
            return findKthLargest(nums, begin, j - 1, k - end + j - 1);
        }
    }

    public static void main(String[] args) {
        new _215_Kth_Largest_Element_in_an_Array().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }
}
