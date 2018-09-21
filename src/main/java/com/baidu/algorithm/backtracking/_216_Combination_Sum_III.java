/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * _216_Combination_Sum_III
 *
 * @author xuhaoran01
 */
public class _216_Combination_Sum_III {
    public void dfs(List<List<Integer>> res, List<Integer> curRes, int cur, int k, int n) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(curRes));
            }

            return;
        } else if (n <= 0 || cur > 9) {
            return;
        }

        dfs(res, curRes, cur + 1, k, n);

        curRes.add(cur);
        dfs(res, curRes, cur + 1, k - 1, n - cur);
        curRes.remove(curRes.size() - 1);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 1, k, n);

        return res;
    }
}
