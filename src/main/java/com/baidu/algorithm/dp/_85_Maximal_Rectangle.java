/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

import java.util.Stack;

/**
 * _85_Maximal_Rectangle
 *
 * @author xuhaoran01
 */
public class _85_Maximal_Rectangle {

    private int largestRectangle(int[] height) {

        int res = 0, len = height.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= len; ) {
            int h = i < len ? height[i] : 0;
            if (stack.isEmpty() || h >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                res = Math.max(res, height[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        return res;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length, res = 0;
        int[] heights = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            res = Math.max(res, largestRectangle(heights));
        }

        return res;
    }

    public static void main(String[] args) {

        char[][] matrix = {
                "10100".toCharArray(),
                "10111".toCharArray(),
                "11111".toCharArray(),
                "10010".toCharArray()
        };

        System.out.println(new _85_Maximal_Rectangle().maximalRectangle(matrix));
    }
}
