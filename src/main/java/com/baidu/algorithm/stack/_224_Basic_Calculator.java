/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.util.Stack;

/**
 * _224_Basic_Calculator
 *
 * @author xuhaoran01
 */
public class _224_Basic_Calculator {

    public int calculate(String s) {
        int res = 0;
        if (s != null && !s.isEmpty()) {
            Stack<Integer> st = new Stack<>();
            int sign = 1, tmp = 0;

            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    continue;
                } else if (c == '(') {
                    st.push(res);
                    st.push(sign);
                    res = 0;
                    sign = 1;
                } else if (c == ')') {
                    res += sign * tmp;
                    tmp = 0;
                    res *= st.pop();
                    res += st.pop();
                } else if (c == '+') {
                    res += sign * tmp;
                    tmp = 0;
                    sign = 1;
                } else if (c == '-') {
                    res += sign * tmp;
                    tmp = 0;
                    sign = -1;
                } else if (Character.isDigit(c)) {
                    tmp = tmp * 10 + c - '0';
                } else {
                    return 0; // invalid input
                }
            }

            if (tmp > 0) {
                res += tmp * sign;
            }
        }

        return res;
    }
}
