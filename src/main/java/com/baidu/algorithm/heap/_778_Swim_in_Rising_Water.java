/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * _778_Swim_in_Rising_Water
 *
 * @author xuhaoran01
 */
public class _778_Swim_in_Rising_Water {

    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        Queue<int[]> queue = new PriorityQueue<>((x, y) -> (x[2] - y[2]));
        queue.add(new int[]{0, 0, grid[0][0]});
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            if (!visited[cur[0]][cur[1]]) {
                visited[cur[0]][cur[1]] = true;

                for (int[] mov : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                    int x = cur[0] + mov[0];
                    int y = cur[1] + mov[1];

                    if (x < 0 || x >= n || y < 0 || y >= n) {
                        continue;
                    }

                    int curMax = Math.max(cur[2], grid[x][y]);
                    if (x == n - 1 && y == n - 1) {
                        return curMax;
                    }

                    queue.add(new int[]{x, y, curMax});
                }
            }
        }

        return 0;
    }
}
