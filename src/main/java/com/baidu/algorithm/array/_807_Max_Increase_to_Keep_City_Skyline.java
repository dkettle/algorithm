/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _807_Max_Increase_to_Keep_City_Skyline
 *
 * @author xuhaoran01
 */
public class _807_Max_Increase_to_Keep_City_Skyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int[] top = new int[n];
        int[] left = new int[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                top[j] = Math.max(top[j], grid[i][j]);
                left[i] = Math.max(left[i], grid[i][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.max(0, Math.min(left[i], top[j]) - grid[i][j]);
            }
        }

        return res;
    }
}
