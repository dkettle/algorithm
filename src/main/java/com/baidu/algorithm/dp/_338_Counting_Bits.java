/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _338_Counting_Bits
 *
 * @author xuhaoran01
 */
public class _338_Counting_Bits {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }

        return res;
    }
}
