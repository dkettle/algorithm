/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * _52_N_Queens_II
 *
 * @author xuhaoran01
 */
public class _52_N_Queens_II {

    private int count = 0;

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

    private void dfs(List<Integer> oneRes, int index, int n) {

        if (index == n) {
            count++;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(i, oneRes)) {
                oneRes.add(i);
                dfs(oneRes, index + 1, n);
                oneRes.remove(oneRes.size() - 1);
            }
        }
    }

    public int totalNQueens(int n) {
        dfs(new ArrayList<>(), 0, n);

        return count;
    }
}
