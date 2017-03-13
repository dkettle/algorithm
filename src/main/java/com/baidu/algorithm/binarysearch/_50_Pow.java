/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearch;

/**
 * _50_Pow
 *
 * @author xuhaoran01
 */
public class _50_Pow {

    public double myPow(double x, int n) {

        if (Math.abs(x) < 1e-5) {
            return 0;
        }
        else if (n == 0) {
            return 1;
        }
        else if (n == 1) {
            return x;
        }
        else if (n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        }
        else if (n % 2 == 0) {
            double temp = myPow(x, n / 2);
            return temp * temp;
        }
        else {
            double temp = myPow(x, n / 2);
            return temp * temp * x;
        }
    }
}
