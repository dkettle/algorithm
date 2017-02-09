/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bitmanipulation;

/**
 * _342_Power_of_Four
 *
 * @author xuhaoran01
 */
public class _342_Power_of_Four {

    public boolean isPowerOfFour(int num) {

        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
}
