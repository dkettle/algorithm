/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _304_Range_Sum_Query_2D_Immutable
 *
 * @author xuhaoran01
 */
public class _304_Range_Sum_Query_2D_Immutable {
    class NumMatrix {

        private int[][] cumMat;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }

            int m = matrix.length, n = matrix[0].length;
            cumMat = new int[m + 1][n + 1];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    cumMat[i + 1][j + 1] = cumMat[i][j + 1] + cumMat[i + 1][j] - cumMat[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return cumMat[row2 + 1][col2 + 1] - cumMat[row2 + 1][col1] - cumMat[row1][col2 + 1] + cumMat[row1][col1];
        }
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new _304_Range_Sum_Query_2D_Immutable().new NumMatrix(
                new int[][]{
                        {3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}
                }
        );

        numMatrix.sumRegion(2, 1, 4, 3);

    }
}
