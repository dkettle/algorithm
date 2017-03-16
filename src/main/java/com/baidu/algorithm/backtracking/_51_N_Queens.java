/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * _51_N_Queens
 *
 * @author xuhaoran01
 */
public class _51_N_Queens {

    private boolean isValid(int x, List<Integer> list) {

        int y = list.size();

        for (int i = 0; i < list.size(); i++) {
            int j = list.get(i);
            if (x == j) {
                return false;
            }

            if (x + y == i + j || y - i == x - j) {
                return false;
            }
        }

        return true;
    }

    private void dfs(List<List<String>> res, List<Integer> oneRes, int index, int n) {

        if (index == n) {
            List<String> temp = new ArrayList<>();
            for (int v : oneRes) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append('.');
                }

                sb.setCharAt(v, 'Q');

                temp.add(sb.toString());
            }

            res.add(temp);
        }

        for (int i = 0; i < n; i++) {
            if (isValid(i, oneRes)) {
                oneRes.add(i);
                dfs(res, oneRes, index + 1, n);
                oneRes.remove(oneRes.size() - 1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 0, n);

        return res;
    }
}
