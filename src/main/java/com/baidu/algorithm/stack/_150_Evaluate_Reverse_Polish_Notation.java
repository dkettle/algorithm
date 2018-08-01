/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.util.Stack;

/**
 * _150_Evaluate_Reverse_Polish_Notation
 *
 * @author xuhaoran01
 */
public class _150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();

                if ("+".equals(token)) {
                    stack.push(num1 + num2);
                } else if ("-".equals(token)) {
                    stack.push(num1 - num2);
                } else if ("*".equals(token)) {
                    stack.push(num1 * num2);
                } else {
                    stack.push(num1 / num2);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
