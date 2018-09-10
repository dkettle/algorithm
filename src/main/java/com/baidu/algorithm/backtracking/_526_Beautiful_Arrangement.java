/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * _526_Beautiful_Arrangement
 *
 * @author xuhaoran01
 */
public class _526_Beautiful_Arrangement {

    private int res;
    private boolean[] used;

    private void dfs(int pos) {
        if (pos == 0) {
            res++;
        } else {
            for (int i = 1; i < used.length; i++) {
                if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                    used[i] = true;
                    dfs(pos - 1);
                    used[i] = false;
                }
            }
        }
    }

    public int countArrangement(int N) {
        res = 0;
        used = new boolean[N + 1];

        dfs(N);

        return res;
    }

    public static void main(String[] args) {
        new _526_Beautiful_Arrangement().countArrangement(2);
    }
}
