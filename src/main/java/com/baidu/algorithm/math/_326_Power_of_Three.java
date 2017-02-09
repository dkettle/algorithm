/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

import java.time.temporal.Temporal;

import com.baidu.algorithm.util.Utils;

/**
 * _326_Power_of_Three
 *
 * @author xuhaoran01
 */
public class _326_Power_of_Three {

    public boolean isPowerOfThree(int n) {

        long maxInt = Integer.MAX_VALUE;
        int maxIntPowerOfThree = 0;
        for (int i = 0; ; i++) {
            if (Math.pow(3, i) > maxInt) {
                maxIntPowerOfThree = (int) Math.pow(3, i - 1);
                break;
            }
        }

        return maxIntPowerOfThree % n == 0;
    }

    private void test(Utils x) {

        x = new Utils();
    }

    public static void main(String[] args) {

        Utils x = null;
        new _326_Power_of_Three().test(x);

        System.out.println(x);
    }
}
