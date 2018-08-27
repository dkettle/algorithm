/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _834_Sum_of_Distances_in_Tree
 *
 * @author xuhaoran01
 */
public class _834_Sum_of_Distances_in_Tree {
    private void dfs1(int child, int father, int[] count, int[] disSum, List<List<Integer>> edges) {
        for (int sub : edges.get(child)) {
            if (sub != father) {
                dfs1(sub, child, count, disSum, edges);
                count[child] += count[sub];
                disSum[child] += count[sub] + disSum[sub];
            }
        }
    }

    private void dfs2(int child, int father, int[] count, int[] disSum, List<List<Integer>> edges) {
        for (int sub : edges.get(child)) {
            if (sub != father) {
                disSum[sub] = disSum[child] - count[sub] + count.length - count[sub];
                dfs2(sub, child, count, disSum, edges);
            }
        }
    }

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] count = new int[N];
        Arrays.fill(count, 1);

        int[] disSum = new int[N];
        List<List<Integer>> edge = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            edge.add(new ArrayList<>());
        }

        for (int[] ed : edges) {
            edge.get(ed[0]).add(ed[1]);
            edge.get(ed[1]).add(ed[0]);
        }

        dfs1(0, -1, count, disSum, edge);
        dfs2(0, -1, count, disSum, edge);

        return disSum;
    }
}
