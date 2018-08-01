/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.Arrays;

/**
 * _79_Word_Search
 *
 * @author xuhaoran01
 */
public class _79_Word_Search {

    private boolean dfs(char[][] board, int px, int py, String word, int pos, boolean[][] visited) {
        if (pos == word.length()) {
            return true;
        }

        if (px < 0 || px >= board.length || py < 0 || py >= board[0].length || visited[px][py] || word.charAt(pos) != board[px][py]) {
            return false;
        }

        visited[px][py] = true;
        for (int[] move : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
            if (dfs(board, px + move[0], py + move[1], word, pos + 1, visited)) {
                return true;
            }
        }
        visited[px][py] = false;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        } else if (word.isEmpty()) {
            return true;
        }

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
