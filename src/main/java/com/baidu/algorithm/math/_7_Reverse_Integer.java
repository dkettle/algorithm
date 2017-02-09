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

        long a = (long) x;

        long rev = 0;
        while (a != 0) {
            rev = rev * 10 + a % 10;
            a /= 10;
        }

        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) rev;
    }
}
