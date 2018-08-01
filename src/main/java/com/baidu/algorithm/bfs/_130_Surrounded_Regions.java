/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * _130_Surrounded_Regions
 *
 * @author xuhaoran01
 */
public class _130_Surrounded_Regions {

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length, n = board[0].length;
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.add(new Point(i, 0));
            }

            if (board[i][n - 1] == 'O') {
                queue.add(new Point(i, n - 1));
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                queue.add(new Point(0, i));
            }

            if (board[m - 1][i] == 'O') {
                queue.add(new Point(m - 1, i));
            }
        }

        while (!queue.isEmpty()) {
            Point pt = queue.remove();
            if (pt.x < 0 || pt.x >= m || pt.y < 0 || pt.y >= n || board[pt.x][pt.y] != 'O') {
                continue;
            }

            board[pt.x][pt.y] = 'M';
            for (int[] mov : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                queue.add(new Point(pt.x + mov[0], pt.y + mov[1]));
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 'M' ? 'O' : 'X';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        new _130_Surrounded_Regions().solve(board);
    }
}
