/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dfs;

/**
 * _547_Friend_Circles
 *
 * @author xuhaoran01
 */
public class _547_Friend_Circles {

    private void dfs(int[][] M, boolean[] found, int i) {
        if (found[i]) {
            return;
        }

        found[i] = true;
        for (int j = 0; j < M[i].length; j++) {
            if (M[i][j] == 1) {
                dfs(M, found, j);
            }
        }
    }

    public int findCircleNum1(int[][] M) {
        int n = M.length, res = 0;
        boolean[] found = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!found[i]) {
                res++;
                dfs(M, found, i);
            }
        }

        return res;
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.size;
    }
}

class UnionFind {
    public int size;
    public int[] father;

    public UnionFind(int n) {
        size = n;

        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public int find(int x) {
        if (father[x] != x) {
            father[x] = find(father[x]);
        }

        return father[x];
    }

    public void union(int x, int y) {
        int fx = find(x),
                fy = find(y);
        if (fx != fy) {
            father[fx] = fy;
            size--;
        }
    }
}
