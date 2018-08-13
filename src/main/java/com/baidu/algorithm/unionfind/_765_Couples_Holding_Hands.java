/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.unionfind;

/**
 * _765_Couples_Holding_Hands
 *
 * @author xuhaoran01
 */
public class _765_Couples_Holding_Hands {
    class UnionFind {
        public int n;
        public int[] father;

        public UnionFind(int n) {
            this.n = n;
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);

            if (x != y) {
                father[x] = y;
                n--;
            }
        }

        public int find(int x) {
            if (x != father[x]) {
                father[x] = find(father[x]);
            }

            return father[x];
        }
    }

    public int minSwapsCouples(int[] row) {
        if (row == null || row.length == 0 || row.length % 2 != 0) {
            return 0;
        }

        int n = row.length >> 1;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int x = row[2 * i] / 2;
            int y = row[2 * i + 1] / 2;
            uf.union(x, y);
        }

        return n - uf.n;
    }

    public static void main(String[] args) {
        new _765_Couples_Holding_Hands().minSwapsCouples(new int[]{0, 2, 1, 3});
    }
}
