/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.heap;

import java.util.PriorityQueue;
import java.util.regex.Matcher;

/**
 * _407_Trapping_Rain_Water_II
 *
 * @author xuhaoran01
 */
public class _407_Trapping_Rain_Water_II {

    class Cell {

        public int x, y, h;

        public Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    // 和_42_Trapping_Rain_Water O(1)解法思路一样
    public int trapRainWater(int[][] heightMap) {

        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length, n = heightMap[0].length, res = 0;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<Cell> pq = new PriorityQueue<>((x, y) -> x.h - y.h);

        for (int i = 0; i < m; i++) {
            visited[i][0] = visited[i][n - 1] = true;
            pq.add(new Cell(i, 0, heightMap[i][0]));
            pq.add(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int i = 1; i < n - 1; i++) {
            visited[0][i] = visited[m - 1][i] = true;
            pq.add(new Cell(0, i, heightMap[0][i]));
            pq.add(new Cell(m - 1, i, heightMap[m - 1][i]));
        }

        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int[] dir : dirs) {
                int x = cell.x + dir[0];
                int y = cell.y + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    pq.add(new Cell(x, y, Math.max(heightMap[x][y], cell.h)));

                    res += Math.max(0, cell.h - heightMap[x][y]);
                }
            }
        }


        return res;
    }
}
