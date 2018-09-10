/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _885_Spiral_Matrix_III
 *
 * @author xuhaoran01
 */
public class _885_Spiral_Matrix_III {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] res = new int[R * C][2];
        res[0][0] = r0;
        res[0][1] = c0;

        int idx = 1, len = 0, d = 0;
        while (idx < R * C) {
            if (d == 0 || d == 2) {
                len++;
            }

            for (int i = 0; i < len; i++) {
                r0 += dir[d][0];
                c0 += dir[d][1];
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
                    res[idx][0] = r0;
                    res[idx][1] = c0;
                    idx++;
                }
            }

            d = (d + 1) % 4;
        }

        return res;
    }
}
