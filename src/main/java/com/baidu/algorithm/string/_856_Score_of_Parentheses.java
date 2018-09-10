/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.Stack;

/**
 * _856_Score_of_Parentheses
 *
 * @author xuhaoran01
 */
public class _856_Score_of_Parentheses {
    private int scoreOfParentheses(String s, int begin, int end) {
        int res = 0, bal = 0;
        for (int i = begin; i <= end; i++) {
            bal += s.charAt(i) == '(' ? 1 : -1;
            if (bal == 0) {
                if (i - begin == 1) {
                    res += 1;
                } else {
                    res += 2 * scoreOfParentheses(s, begin + 1, i - 1);
                }

                begin = i + 1;
            }
        }

        return res;
    }

    // recursion, O(N^2), O(N)
    public int scoreOfParentheses1(String S) {
        if (S == null || S.isEmpty()) {
            return 0;
        }

        return scoreOfParentheses(S, 0, S.length() - 1);
    }

    // stack, O(N), O(N)
    public int scoreOfParentheses(String S) {
        if (S == null || S.isEmpty()) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int t = stack.pop();
                stack.push(stack.pop() + Math.max(2 * t, 1));
            }
        }

        return stack.pop();
    }

}
