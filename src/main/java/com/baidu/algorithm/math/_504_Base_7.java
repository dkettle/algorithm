/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _504_Base_7
 *
 * @author xuhaoran01
 */
public class _504_Base_7 {

    public String convertToBase7(int num) {

        if (num == 0) {
            return "0";
        }

        int sign = 1;
        if (num < 0) {
            sign = -1;
            num = -num;
        }

        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }

        if (sign == -1) {
            sb.append('-');
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        new _504_Base_7().convertToBase7(-7);
    }
}
