/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

import java.util.Arrays;

/**
 * _48_Rotate_Image
 *
 * @author xuhaoran01
 */
public class _48_Rotate_Image {

    private void reverse(int[] arr, int n) {
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            reverse(matrix[i], n);
        }
    }
}
