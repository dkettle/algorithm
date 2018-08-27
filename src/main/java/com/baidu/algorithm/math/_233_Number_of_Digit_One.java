/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _233_Number_of_Digit_One
 *
 * @author xuhaoran01
 */
public class _233_Number_of_Digit_One {

    public int countDigitOne(int n) {
        long res = 0, factor = 1;
        while (n >= factor) {
            long high = n / (factor * 10);
            long cur = (n / factor) % 10;
            long low = n % factor;

            if (cur == 0) {
                res += high * factor;
            } else if (cur == 1) {
                res += high * factor + low + 1;
            } else {
                res += (high + 1) * factor;
            }

            factor *= 10;
        }

        return (int) res;
    }
}
