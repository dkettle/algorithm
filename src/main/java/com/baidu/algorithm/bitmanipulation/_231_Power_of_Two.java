/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bitmanipulation;

/**
 * _231_Power_of_Two
 *
 * @author xuhaoran01
 */
public class _231_Power_of_Two {

    public boolean isPowerOfTwo(int n) {

        return n > 0 && (n & (n - 1)) == 0;
    }
}
