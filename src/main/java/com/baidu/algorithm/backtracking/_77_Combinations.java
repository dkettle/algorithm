/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * _77_Combinations
 *
 * @author xuhaoran01
 */
public class _77_Combinations {

    private void dfs(List<List<Integer>> res, List<Integer> oneRes, int n, int k) {

        if (oneRes.size() == k) {
            res.add(new ArrayList<>(oneRes));
        }
        else if (n > 0) {
            dfs(res, oneRes, n - 1, k);

            oneRes.add(n);
            dfs(res, oneRes, n - 1, k);
            oneRes.remove(oneRes.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (n >= k) {
            dfs(res, new ArrayList<>(), n, k);
        }

        return res;
    }
}
