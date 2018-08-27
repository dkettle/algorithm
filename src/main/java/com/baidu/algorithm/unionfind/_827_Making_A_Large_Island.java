/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.unionfind;

import java.util.HashSet;
import java.util.Set;

/**
 * _827_Making_A_Large_Island
 *
 * @author xuhaoran01
 */
public class _827_Making_A_Large_Island {
    class UnionFind {
        public int[] father;
        public int[] area;

        public UnionFind(int[][] grid) {
            int m = grid.length, n = grid[0].length;

            father = new int[m * n];
            area = new int[m * n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    father[i * n + j] = i * n + j;
                    area[i * n + j] = grid[i][j] == 1 ? 1 : 0;
                }
            }
        }

        public int find(int x) {
            if (father[x] != x) {
                father[x] = find(father[x]);
            }

            return father[x];
        }

        public void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx > fy) {
                father[fy] = fx;
                area[fx] += area[fy];
            } else if (fx < fy) {
                father[fx] = fy;
                area[fy] += area[fx];
            }
        }
    }

    public int largestIsland(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(grid);

        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] mov : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                        int ni = i + mov[0], nj = j + mov[1];
                        if (ni < 0 || ni >= m || nj < 0 || nj >= n || grid[ni][nj] != 1) {
                            continue;
                        }

                        uf.union(i * n + j, ni * n + nj);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, uf.area[uf.find(i * n + j)]);
                } else {
                    int sum = 1;
                    Set<Integer> visited = new HashSet<>();
                    for (int[] mov : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                        int ni = i + mov[0], nj = j + mov[1];
                        if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                            continue;
                        }

                        int fn = uf.find(ni * n + nj);
                        if (!visited.contains(fn)) {
                            sum += uf.area[fn];
                        }

                        visited.add(fn);
                    }

                    res = Math.max(res, sum);
                }
            }
        }

        return res;
    }
}
