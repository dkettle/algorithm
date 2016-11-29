/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.util.Stack;

/**
 * _32_Longest_Valid_Parentheses
 *
 * @author xuhaoran01
 */
public class _32_Longest_Valid_Parentheses {

    // time limited exceeded, but elegent
    public int longestValidParentheses(String s) {

        if (s == null || s.length() <= 1) {
            return 0;
        }

        int res = 0, last = -1;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                st.push(i);
            }
            else {
                if (st.isEmpty()) {
                    last = i;
                }
                else {
                    st.pop();
                    if (st.empty()) {
                        res = Math.max(res, i - last);
                    }
                    else {
                        res = Math.max(res, i - st.peek());
                    }
                }
            }
        }

        return res;
    }
}
