/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dfs;

/**
 * _488_Zuma_Game
 *
 * @author xuhaoran01
 */
public class _488_Zuma_Game {

    public int findMinStep(String board, String hand) {
        int[] count = new int[26];
        for (char c : hand.toCharArray()) {
            count[c - 'A']++;
        }

        int res = findMinStep(board + "#", count);
        return res == 6 ? -1 : res;
    }

    private int findMinStep(String board, int[] count) {
        board = removeBall(board);
        if (board.equals("#")) {
            return 0;
        }

        int res = 6;
        for (int i = 0, j = 0; j < board.length(); j++) {
            if (board.charAt(i) == board.charAt(j)) {
                continue;
            }

            int need = 3 - (j - i), idx = board.charAt(i) - 'A';
            if (count[idx] >= need) {
                count[idx] -= need;
                res = Math.min(res, need + findMinStep(board.substring(0, i) + board.substring(j), count));
                count[idx] += need;
            }

            i = j;
        }

        return res;
    }

    private String removeBall(String board) {
        for (int i = 0, j = 0; j < board.length(); j++) {
            if (board.charAt(i) == board.charAt(j)) {
                continue;
            }

            if (j - i >= 3) {
                return removeBall(board.substring(0, i) + board.substring(j));
            } else {
                i = j;
            }
        }

        return board;
    }
}
