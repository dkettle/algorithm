/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bitmanipulation;

/**
 * _461_Hamming_Distance
 *
 * @author xuhaoran01
 */
public class _461_Hamming_Distance {

    private int countOne(int val) {

        int res = 0;
        while (val > 0) {
            val = val & (val - 1);
            res++;
        }

        return res;
    }

    public int hammingDistance(int x, int y) {

        int xorVal = x ^ y;
        return countOne(xorVal);
    }
}
