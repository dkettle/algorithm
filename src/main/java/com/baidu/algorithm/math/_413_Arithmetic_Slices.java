/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _413_Arithmetic_Slices
 *
 * @author xuhaoran01
 */
public class _413_Arithmetic_Slices {

    private int numberOfSubArr(int val) {

        return (val - 1) * (val - 2) / 2;
    }

    public int numberOfArithmeticSlices(int[] A) {

        if (A == null || A.length < 3) {
            return 0;
        }

        int start = 0, gap = A[1] - A[0], res = 0;
        for (int i = 2; i < A.length; i++) {

            int diff = A[i] - A[i - 1];
            if (diff != gap) {
                res += numberOfSubArr(i - start);

                start = i - 1;
                gap = diff;
            }
        }

        res += numberOfSubArr(A.length - start);

        return res;
    }

    public int numberOfArithmeticSlices1(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        int res = 0, n = A.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }
        }

        return res;
    }
}
