/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bitmanipulation;

/**
 * _191_Number_of_1_Bits
 *
 * @author xuhaoran01
 */
public class _191_Number_of_1_Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int val) {

        val = (val & 0x55555555) + ((val >> 1) & 0x55555555);
        val = (val & 0x33333333) + ((val >> 2) & 0x33333333);
        val = (val & 0x0f0f0f0f) + ((val >> 4) & 0x0f0f0f0f);
        val = (val & 0x00ff00ff) + ((val >> 8) & 0x00ff00ff);
        val = (val & 0x0000ffff) + ((val >> 16) & 0x0000ffff);

        return val;
    }

    public static void main(String[] args) {

        new _191_Number_of_1_Bits().hammingWeight(122);
    }
}
