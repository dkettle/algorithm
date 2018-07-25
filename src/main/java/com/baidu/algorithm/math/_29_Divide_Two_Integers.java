/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

import com.baidu.algorithm.annotation.Note;

/**
 * _29_Divide_Two_Integers
 *
 * @author xuhaoran01
 */
public class _29_Divide_Two_Integers {

//    @Note(desc = "first convert to long then abs")
//    public int divide(int dd, int di) {
//
//        long res = 0;
//        long dividend = Math.abs((long) dd);
//        long divisor = Math.abs((long) di);
//
//        while (dividend >= divisor) {
//            int a = 1;
//            while (dividend >= (divisor << a)) {
//                a++;
//            }
//
//            dividend -= divisor << (a - 1);
//            res += (long) 1 << (a - 1);
//        }
//
//        if (((dd ^ di) & (1 << 31)) != 0) {
//            res = -res;
//        }
//
//        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) res;
//    }

    @Note(desc = "Print an integer in binary format")
    public static void main(String[] args) {
        new _29_Divide_Two_Integers().divide(-2147483648, -1);

        System.out.println(1 << 31);
        System.out.println(Integer.toBinaryString(1 << 31));
        System.out.println(Long.toBinaryString((long)(1 << 31)));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }

    public int divide(int dividend, int divisor) {
        long res = 0, dd = Math.abs((long) dividend), ds = Math.abs((long) divisor);
        while (dd >= ds) {
            int shift = 1;
            while (dd >= (ds << shift)) {
                shift++;
            }

            dd -= (ds << (shift - 1));
            res += (long) 1 << (shift - 1);
        }

        if (((dividend ^ divisor) & (1 << 31)) != 0) {
            res = -res;
        }

        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? Integer.MAX_VALUE : (int) res;
    }
}
