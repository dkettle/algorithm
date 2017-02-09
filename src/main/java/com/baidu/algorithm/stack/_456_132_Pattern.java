/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.util.Stack;

import com.baidu.algorithm.annotation.Note;

/**
 * _456_132_Pattern
 *
 * @author xuhaoran01
 */
public class _456_132_Pattern {

    @Note(desc = "reason of iterate from end")
    // s1 s2 s3  s2 > s3 > s1
    // when iterate we find max, which is s2, from end we can easily save s3, second max relative to s2
    public boolean find132pattern(int[] nums) {

        if (nums == null || nums.length < 3) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] < s3) {
                return true;
            }
            else {
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    s3 = stack.pop();
                }
            }

            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        new _456_132_Pattern().find132pattern(new int[]{3, 5, 0, 3, 4});
    }
}
