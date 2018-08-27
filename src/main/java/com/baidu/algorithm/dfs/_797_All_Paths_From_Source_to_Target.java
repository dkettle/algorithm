/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * _797_All_Paths_From_Source_to_Target
 *
 * @author xuhaoran01
 */
public class _797_All_Paths_From_Source_to_Target {

    private void dfs(List<List<Integer>> res, List<Integer> curRes, int[][] graph, int pos) {
        if (pos == graph.length - 1) {
            res.add(new ArrayList<>(curRes));
            return;
        } else {
            for (int next : graph[pos]) {
                curRes.add(next);
                dfs(res, curRes, graph, next);
                curRes.remove(curRes.size() - 1);
            }
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return res;
        }

        List<Integer> curRes = new ArrayList<>();
        curRes.add(0);

        dfs(res, curRes, graph, 0);

        return res;
    }

    public static void main(String[] args) {
        new _797_All_Paths_From_Source_to_Target().allPathsSourceTarget(new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        });
    }
}
