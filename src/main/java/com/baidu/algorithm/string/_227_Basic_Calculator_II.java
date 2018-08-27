/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.Stack;

/**
 * _227_Basic_Calculator_II
 *
 * @author xuhaoran01
 */
public class _227_Basic_Calculator_II {

    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        s = s.replaceAll(" +", "");
        int res = 0, prev = 0, i = 0, n = s.length();
        char sign = '+';
        while (i < n) {
            int cur = 0;
            while (i < n && Character.isDigit(s.charAt(i))) {
                cur = cur * 10 + s.charAt(i) - '0';
                i++;
            }

            switch (sign) {
                case '+':
                    res += prev;
                    prev = cur;
                    break;
                case '-':
                    res += prev;
                    prev = -cur;
                    break;
                case '*':
                    prev *= cur;
                    break;
                case '/':
                    prev /= cur;
                    break;
                default:
                    return 0; // invalid
            }

            if (i < n) {
                sign = s.charAt(i++);
            }
        }

        return res + prev;
    }
}
