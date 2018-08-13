/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

import java.util.PriorityQueue;

/**
 * _480_Sliding_Window_Median
 *
 * @author xuhaoran01
 */
public class _480_Sliding_Window_Median {

    private PriorityQueue<Integer> left = new PriorityQueue<>((x, y) -> y.compareTo(x)); // maxHeap
    private PriorityQueue<Integer> right = new PriorityQueue<>((x, y) -> x.compareTo(y)); // minHeap

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return new double[0];
        }

        int n = nums.length;
        double[] res = new double[n - k + 1];
        for (int i = 0; i < n; i++) {
            add(nums[i]);

            if (i >= k - 1) {
                res[i - k + 1] = getMedian();
                remove(nums[i - k + 1]);
            }
        }

        return res;
    }

    private void add(int v) {
        left.add(v);
        right.add(left.remove());

        while (left.size() < right.size()) {
            left.add(right.remove());
        }
    }

    private void remove(int v) {
        if (v <= left.peek()) {
            left.remove(v);
            if (left.size() < right.size()) {
                left.add(right.remove());
            }
        } else {
            right.remove(v);
            if (left.size() > right.size() + 1) {
                right.add(left.remove());
            }
        }
    }

    private double getMedian() {
        if (left.size() == right.size()) {
            return ((double) left.peek() + (double) right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }

    public static void main(String[] args) {
        new _480_Sliding_Window_Median().medianSlidingWindow(
                new int[]{-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648},
                3);
    }

}


