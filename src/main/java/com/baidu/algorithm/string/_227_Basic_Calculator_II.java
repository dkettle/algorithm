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

        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.replaceAll(" +", "");
        char sign = '+';
        int preVal = 0, res = 0, i = 0;

        while (i < s.length()) {

            int curVal = 0;
            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                curVal = curVal * 10 + s.charAt(i) - '0';
                i++;
            }

            if (sign == '+') {
                res += preVal;
                preVal = curVal;
            }
            else if (sign == '-') {
                res += preVal;
                preVal = -curVal;
            }
            else if (sign == '*') {
                preVal *= curVal;
            }
            else {
                preVal /= curVal;
            }

            if (i < s.length()) {
                sign = s.charAt(i);
                i++;
            }
        }

        return res + preVal;
    }
}
