/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _829_Consecutive_Numbers_Sum
 *
 * @author xuhaoran01
 */
public class _829_Consecutive_Numbers_Sum {
    // x + 1, x + 2, ..., x +k
    // x >= 0, k >= 1
    // 2N = k(2x + k + 1)
    public int consecutiveNumbersSum(int N) {
        int res = 0, kMax = (int) Math.sqrt(2 * N);
        for (int k = 1; k <= kMax; k++) {
            if (2 * N % k == 0) {
                int t = 2 * N / k - k - 1;
                if (t % 2 == 0) {
                    res++;
                }
            }
        }

        return res;
    }
}
