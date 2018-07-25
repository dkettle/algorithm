/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _7_Reverse_Integer
 *
 * @author xuhaoran01
 */
public class _7_Reverse_Integer {


    public int reverse(int x) {
        long rs = 0;
        while (x != 0) {
            rs = rs * 10 + x % 10;
            x /= 10;
        }

        if (rs > Integer.MAX_VALUE || rs < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) rs;
    }
}
