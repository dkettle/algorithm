/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.lang.annotation.ElementType;
import java.util.Stack;

/**
 * _20_Valid_Parentheses
 *
 * @author xuhaoran01
 */
public class _20_Valid_Parentheses {

    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '{':
                    st.push('}');
                    break;
                case '[':
                    st.push(']');
                    break;
                case '(':
                    st.push(')');
                    break;
                case '}':
                    if (st.isEmpty() || !st.pop().equals('}')) {
                        return false;
                    }
                    break;
                case ']':
                    if (st.isEmpty() || !st.pop().equals(']')) {
                        return false;
                    }
                    break;
                case ')':
                    if (st.isEmpty() || !st.pop().equals(')')) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }


        return st.isEmpty();
    }
}
