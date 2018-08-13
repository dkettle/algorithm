/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dfs;

/**
 * _329_Longest_Increasing_Path_in_a_Matrix
 *
 * @author xuhaoran01
 */
public class _329_Longest_Increasing_Path_in_a_Matrix {

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {

        int m = matrix.length, n = matrix[0].length;
        if (cache[i][j] != 0) {
            return cache[i][j];
        } else {
            int res = 1;
            for (int[] mov : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                int nx = i + mov[0], ny = j + mov[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] > matrix[i][j]) {
                    res = Math.max(res, 1 + dfs(matrix, nx, ny, cache));
                }
            }

            cache[i][j] = res;
            return res;
        }
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length, res = 0;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j, cache));
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1},
        };

        new _329_Longest_Increasing_Path_in_a_Matrix().longestIncreasingPath(matrix);
    }
}
