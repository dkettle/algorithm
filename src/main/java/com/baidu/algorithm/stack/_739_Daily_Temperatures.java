/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.util.Stack;

/**
 * _739_Daily_Temperatures
 *
 * @author xuhaoran01
 */
public class _739_Daily_Temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }

        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            stack.push(i);
        }

        return res;
    }
}
