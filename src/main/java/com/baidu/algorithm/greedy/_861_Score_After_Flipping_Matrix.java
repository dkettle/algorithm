/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.greedy;

/**
 * _861_Score_After_Flipping_Matrix
 *
 * @author xuhaoran01
 */
public class _861_Score_After_Flipping_Matrix {

    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int m = A.length, n = A[0].length, res = m * (1 << (n - 1));
        for (int i = 1; i < n; i++) {
            int ones = 0;
            for (int j = 0; j < m; j++) {
                ones += A[j][i] == A[j][0] ? 1 : 0;
            }

            res += Math.max(ones, m - ones) * (1 << (n - i - 1));
        }

        return res;
    }
}
