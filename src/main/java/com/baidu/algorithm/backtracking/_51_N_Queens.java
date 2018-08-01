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

//    private boolean isValid(int x, List<Integer> list) {
//
//        int j = list.size();
//
//        for (int i = 0; i < list.size(); i++) {
//            int y = list.get(i);
//            if (x == y) {
//                return false;
//            }
//
//            if (x + j == y + i || j - i == x - y) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private void dfs(List<List<String>> res, List<Integer> oneRes, int index, int n) {
//
//        if (index == n) {
//            List<String> temp = new ArrayList<>();
//            for (int v : oneRes) {
//                StringBuilder sb = new StringBuilder();
//                for (int i = 0; i < n; i++) {
//                    sb.append('.');
//                }
//
//                sb.setCharAt(v, 'Q');
//
//                temp.add(sb.toString());
//            }
//
//            res.add(temp);
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (isValid(i, oneRes)) {
//                oneRes.add(i);
//                dfs(res, oneRes, index + 1, n);
//                oneRes.remove(oneRes.size() - 1);
//            }
//        }
//    }
//
//    public List<List<String>> solveNQueens(int n) {
//
//        List<List<String>> res = new ArrayList<>();
//        dfs(res, new ArrayList<>(), 0, n);
//
//        return res;
//    }

    private boolean isValid(List<Integer> curRes, int c2, int r2) {
        for (int c1 = 0; c1 < c2; c1++) {
            int r1 = curRes.get(c1);
            if (r1 == r2) {
                return false;
            }

            if (c1 + r1 == c2 + r2 || c1 - c2 == r1 - r2) {
                return false;
            }
        }
        return true;
    }

    private void solveNQueens(List<List<String>> res, List<Integer> curRes, int c, int n) {
        if (c == n) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append('.');
                }
                sb.setCharAt(curRes.get(i), 'Q');

                tmp.add(sb.toString());
            }

            res.add(tmp);
        } else {
            for (int i = 0; i < n; i++) {
                if (isValid(curRes, c, i)) {
                    curRes.add(i);
                    solveNQueens(res, curRes, c + 1, n);
                    curRes.remove(curRes.size() - 1);
                }
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        solveNQueens(res, new ArrayList<>(), 0, n);

        return res;
    }
}
