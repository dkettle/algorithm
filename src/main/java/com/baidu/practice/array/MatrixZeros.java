/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.array;

import java.util.Arrays;
import java.util.Random;

/**
 * MatrixZeros
 *
 * @author xuhaoran01
 */
public class MatrixZeros {

    public void setZeros(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) {
            return;
        }

        int m = nums.length, n = nums[0].length;
        boolean rowZero = false, colZero = false;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 0) {
                    if (i == 0) {
                        rowZero = true;
                    }

                    if (j == 0) {
                        colZero = true;
                    }

                    if (i > 0 && j > 0) {
                        nums[0][j] = nums[i][0] = 0;
                    }

                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums[i][0] == 0 || nums[0][j] == 0) {
                    nums[i][j] = 0;
                }
            }
        }

        if (rowZero) {
            for (int i = 0; i < n; i++) {
                nums[0][i] = 0;
            }
        }

        if (colZero) {
            for (int i = 0; i < m; i++) {
                nums[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int m = 4, n = 5;
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = rand.nextInt(5);
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }

        MatrixZeros mz = new MatrixZeros();
        mz.setZeros(nums);

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}
