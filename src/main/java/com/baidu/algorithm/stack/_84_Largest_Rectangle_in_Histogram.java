/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.util.Stack;

/**
 * _84_Largest_Rectangle_in_Histogram
 *
 * @author xuhaoran01
 */
public class _84_Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0) {
            return 0;
        }

        int res = 0, len = heights.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= len; ) {

            int height = i == len ? 0 : heights[i];
            if (stack.isEmpty() || heights[stack.peek()] <= height) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                res = Math.max(res, heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new _84_Largest_Rectangle_in_Histogram().largestRectangleArea(new int[]{2, 1, 2});
    }
}
