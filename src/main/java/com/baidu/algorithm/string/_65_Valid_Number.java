/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _65_Valid_Number
 *
 * @author xuhaoran01
 */
public class _65_Valid_Number {

    public boolean isNumber(String s) {
        s = s.trim();
        boolean sign = false, num = false, dot = false, exp = false;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '+' || c == '-') {
                if (sign || num || dot) {
                    return false;
                }
                sign = true;
            } else if (c == '.') {
                if (dot || exp) {
                    return false;
                }
                dot = true;
            } else if (c == 'e' || c == 'E') {
                if (!num || exp) {
                    return false;
                }
                exp = true;
                sign = false;
                num = false;
                dot = false;
            } else {
                return false;
            }
        }

        return num;
    }
}
