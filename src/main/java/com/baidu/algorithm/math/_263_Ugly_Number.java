/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _263_Ugly_Number
 *
 * @author xuhaoran01
 */
public class _263_Ugly_Number {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }

        int[] factors = new int[]{2, 3, 5};
        for (int factor : factors) {
            while (num % factor == 0) {
                num /= factor;
            }
        }

        return num == 1;
    }
}
