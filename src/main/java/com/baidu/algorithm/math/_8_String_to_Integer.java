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

        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        int index = 0, sign = 1;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            if (str.charAt(index) == '-') {
                sign = -1;
            }

            index++;
            if (index == str.length()) {
                return 0;
            }
        }

        long res = 0;
        while (index < str.length()) {
            char c = str.charAt(index);
            if (Character.isDigit(c)) {
                res = res * 10 + c - '0';
            }
            else {
                break;
            }

            index++;

            if (sign * res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            else if (sign * res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) (sign * res);
    }

    public static void main(String[] args) {

        new _8_String_to_Integer().myAtoi("-1");
    }
}
