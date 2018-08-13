/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * _773_Sliding_Puzzle
 *
 * @author xuhaoran01
 */
public class _773_Sliding_Puzzle {

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));

        return sb.toString();
    }

    public int slidingPuzzle(int[][] board) {
        if (board == null || board[0] == null) {
            return 0;
        }

        String target = "123450";
        String start = "";
        for (int[] arr : board) {
            for (int val : arr) {
                start += val;
            }
        }

        int[][] dirs = new int[][]{
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {3, 5, 1},
                {2, 4}
        };

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        int res = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String cur = queue.remove();
                if (!visited.contains(cur)) {
                    visited.add(cur);

                    if (cur.equals(target)) {
                        return res;
                    }

                    int zeroIndex = cur.indexOf('0');
                    for (int dir : dirs[zeroIndex]) {
                        queue.add(swap(cur, zeroIndex, dir));
                    }
                }
            }
            res++;
        }

        return -1;
    }
}
