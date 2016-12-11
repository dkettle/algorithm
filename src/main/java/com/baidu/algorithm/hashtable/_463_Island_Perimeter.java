/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

/**
 * _463_Island_Perimeter
 *
 * @author xuhaoran01
 */
public class _463_Island_Perimeter {

    public int islandPerimeter(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int grids = 0, connects = 0;
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grids++;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        connects++;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        connects++;
                    }
                }
            }
        }

        return 4 * grids - 2 * connects;
    }
}
