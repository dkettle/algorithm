/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _69_Sqrt
 *
 * @author xuhaoran01
 */
public class _69_Sqrt {

    public int mySqrt1(int x) {

        if (x == 0) {
            return 0;
        }

        int left = 1, right = x;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int val = x / mid;

            if (val == mid) {
                return mid;
            } else if (val < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    // newton's method
    public int mySqrt(int x) {

        double t1 = 0, t2 = 1;
        while (Math.abs(t2 - t1) > 1e-5) {
            t1 = t2;
            t2 = t1 / 2 + (double) x / (2 * t1);
        }

        return (int) t1;
    }
}

