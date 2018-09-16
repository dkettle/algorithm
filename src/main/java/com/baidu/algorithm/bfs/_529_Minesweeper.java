/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * _529_Minesweeper
 *
 * @author xuhaoran01
 */
public class _529_Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else if (board[click[0]][click[1]] == 'E') {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(click);

            while (!queue.isEmpty()) {
                int[] cur = queue.remove();
                if (board[cur[0]][cur[1]] != 'E') {
                    continue;
                }

                int mineCnt = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int nx = cur[0] + i, ny = cur[1] + j;
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'M') {
                            mineCnt++;
                        }
                    }
                }

                if (mineCnt == 0) {
                    board[cur[0]][cur[1]] = 'B';
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int nx = cur[0] + i, ny = cur[1] + j;
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'E') {
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                } else {
                    board[cur[0]][cur[1]] = Character.forDigit(mineCnt, 10);
                }
            }
        }

        return board;
    }

    public static void main(String[] args) {
        char[][] board = {"EEEEE".toCharArray(), "EEMEE".toCharArray(), "EEEEE".toCharArray(), "EEEEE".toCharArray()};

        new _529_Minesweeper().updateBoard(board, new int[]{3, 0});
    }
}