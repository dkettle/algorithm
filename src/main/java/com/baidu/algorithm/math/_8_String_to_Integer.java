/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _8_String_to_Integer
 *
 * @author xuhaoran01
 */
public class _8_String_to_Integer {

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }

        int sign = 1, i = 0;
        long rs = 0;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            if (str.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                rs = rs * 10 + (c - '0');
            } else {
                break;
            }

            if (sign * rs > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign * rs < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) (rs * sign);
    }

    public static void main(String[] args) {

        new _8_String_to_Integer().myAtoi("-1");
    }
}
