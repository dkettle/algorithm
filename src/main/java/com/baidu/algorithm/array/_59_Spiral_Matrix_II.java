/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _59_Spiral_Matrix_II
 *
 * @author xuhaoran01
 */
public class _59_Spiral_Matrix_II {

//    public int[][] generateMatrix(int n) {
//
//        int[][] matrix = new int[n][n];
//        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1, pos = 1;
//
//        while (rowBegin <= rowEnd && colBegin <= colEnd) {
//            for (int i = colBegin; i <= colEnd; i++) {
//                matrix[rowBegin][i] = pos++;
//            }
//            rowBegin++;
//
//            for (int i = rowBegin; i <= rowEnd; i++) {
//                matrix[i][colEnd] = pos++;
//            }
//            colEnd--;
//
//            if (rowBegin <= rowEnd) {
//                for (int i = colEnd; i >= colBegin; i--) {
//                    matrix[rowEnd][i] = pos++;
//                }
//                rowEnd--;
//            }
//
//            if (colBegin <= colEnd) {
//                for (int i = rowEnd; i >= rowBegin; i--) {
//                    matrix[i][colBegin] = pos++;
//                }
//                colBegin++;
//            }
//        }
//
//        return matrix;
//    }

    public int[][] generateMatrix(int n) {

        if (n <= 0) {
            return new int[0][0];
        }

        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1, pos = 1;
        int[][] res = new int[n][n];

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                res[rowBegin][i] = pos++;
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                res[i][colEnd] = pos++;
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    res[rowEnd][i] = pos++;
                }
                rowEnd--;
            }

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res[i][colBegin] = pos++;
                }
                colBegin++;
            }
        }

        return res;
    }
}
