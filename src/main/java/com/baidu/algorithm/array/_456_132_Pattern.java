/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

import java.util.Stack;

/**
 * _456_132_Pattern
 *
 * @author xuhaoran01
 */
public class _456_132_Pattern {
    public boolean find132pattern1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int leftMin = nums[0];
        for (int j = 1; j < nums.length - 1; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (leftMin < nums[k] && nums[k] < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
        }

        return false;
    }

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int n = nums.length;
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > leftMin[i]) {
                while (!stack.isEmpty() && stack.peek() <= leftMin[i]) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }

                stack.push(nums[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        new _456_132_Pattern().find132pattern(new int[]{-2, 1, -1});
    }
}
