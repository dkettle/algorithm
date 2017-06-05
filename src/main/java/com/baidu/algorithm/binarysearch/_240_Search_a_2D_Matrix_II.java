/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearch;

/**
 * _240_Search_a_2D_Matrix_II
 *
 * @author xuhaoran01
 */
public class _240_Search_a_2D_Matrix_II {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length > 0 && matrix[0].length > 0) {
            int m = matrix.length, n = matrix[0].length;
            int row = 0, col = n - 1;
            while (row < m && col >= 0) {
                if (matrix[row][col] == target) {
                    return true;
                }
                else if (matrix[row][col] > target) {
                    col--;
                }
                else {
                    row++;
                }
            }
        }

        return false;
    }
}
