/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

/**
 * _402_Remove_K_Digits
 *
 * @author xuhaoran01
 */
public class _402_Remove_K_Digits {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            char c = num.charAt(i);
            if (k > 0 && !st.isEmpty() && st.peek() > c) {
                st.pop();
                k--;
            } else {
                st.push(c);
                i++;
            }
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        new _402_Remove_K_Digits().removeKdigits("1432219", 3);
    }
}
