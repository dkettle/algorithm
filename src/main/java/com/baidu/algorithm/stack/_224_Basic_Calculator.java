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

        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.replaceAll(" +", "");
        int len = s.length(), res = 0;

        Stack<Integer> st = new Stack<>();
        int sign = 1, temp = 0;


        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '+') {
                res += sign * temp;
                temp = 0;
                sign = 1;
            }
            else if (c == '-') {
                res += sign * temp;
                temp = 0;
                sign = -1;
            }
            else if (c == '(') {
                st.push(res);
                st.push(sign);
                sign = 1;
                res = 0;
            }
            else if (c == ')') {
                res += sign * temp;
                temp = 0;
                res *= st.pop();
                res += st.pop();
            }
            else {
                temp = temp * 10 + c - '0';
            }
        }

        if (temp > 0) {
            res += sign * temp;
        }

        return res;
    }
}
