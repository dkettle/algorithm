/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.slidewindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * _239_Sliding_Window_Maximum
 *
 * @author xuhaoran01
 */
public class _239_Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k > nums.length) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            if (!deque.isEmpty() && deque.peekLast() == i - k) {
                deque.removeLast();
            }

            while (!deque.isEmpty() && nums[deque.peekFirst()] <= nums[i]) {
                deque.removeFirst();
            }

            deque.addFirst(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekLast()];
            }
        }

        return res;
    }
}
