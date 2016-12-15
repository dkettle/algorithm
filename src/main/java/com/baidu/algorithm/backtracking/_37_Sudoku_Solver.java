/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.Arrays;

import com.baidu.algorithm.Note;

/**
 * _37_Sudoku_Solver
 *
 * @author xuhaoran01
 */
public class _37_Sudoku_Solver {

    private boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {
            if (c == board[row][i] || c == board[i][col]) {
                return false;
            }
        }

        int m = row / 3 * 3, n = col / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (c == board[m + i][n + j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean solveSudoku(char[][] board, int n) {

        if (n == 81) {
            return true;
        }

        int row = n / 9, col = n % 9;
        if (board[row][col] != '.') {
            return solveSudoku(board, n + 1);
        } else {
            for (char c = '1'; c <= '9'; c++) {
                if (isValid(board, row, col, c)) {
                    board[row][col] = c;
                    if (solveSudoku(board, n + 1)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
            return false;
        }
    }

    public void solveSudoku(char[][] board) {

        solveSudoku(board, 0);
    }

    @Note(desc = "多维数组拷贝")
    @Note(desc = "print array")
    public static void main(String[] args) {

        char[][] board = {"..9748...".toCharArray(), "7........".toCharArray(), ".2.1.9...".toCharArray(),
                "..7...24.".toCharArray(), ".64.1.59.".toCharArray(), ".98...3..".toCharArray(),
                "...8.3.2.".toCharArray(), "........6".toCharArray(), "...2759..".toCharArray()};

        new _37_Sudoku_Solver().solveSudoku(board);

        char[][] res = new char[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(board[i], 0, res[i], 0, 9);
        }

        Arrays.stream(board).forEach(x -> System.out.println(Arrays.toString(x)));
    }
}
