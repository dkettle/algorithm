/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _419_Battleships_in_a_Board
 *
 * @author xuhaoran01
 */
public class _419_Battleships_in_a_Board {

    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }

        int res = 0, m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                } else if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                } else {
                    res++;
                }
            }
        }

        return res;
    }
}
