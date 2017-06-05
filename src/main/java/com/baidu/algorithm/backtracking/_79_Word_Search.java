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

    private boolean dfs(char[][] board, boolean[][] visited, String word, int x, int y, int pos) {

        if (pos == word.length()) {
            return true;
        }

        visited[x][y] = true;

        for (int[] move : new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}}) {

                int xPos = x + move[0], yPos = y + move[1];

                if (xPos >= 0 && xPos < board.length && yPos >= 0 && yPos < board[0].length &&
                            !visited[xPos][yPos] && board[xPos][yPos] == word.charAt(pos)) {
                    if (dfs(board, visited, word, xPos, yPos, pos + 1)) {
                        return true;
                    }
                }
        }

        visited[x][y] = false;

        return false;
    }

    public boolean exist(char[][] board, String word) {

        if (board.length == 0 || board[0].length == 0) {
            return word.length() == 0;
        } else if (word.length() == 0) {
            return true;
        }

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {

                    if (dfs(board, visited, word, i, j, 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
