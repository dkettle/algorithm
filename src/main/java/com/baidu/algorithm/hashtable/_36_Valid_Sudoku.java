/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * _36_Valid_Sudoku
 *
 * @author xuhaoran01
 */
public class _36_Valid_Sudoku {

    public static void main(String[] args) {

        char[][] board = {
                ".87654321".toCharArray(),
                "2........".toCharArray(),
                "3........".toCharArray(),
                "4........".toCharArray(),
                "5........".toCharArray(),
                "6........".toCharArray(),
                "7........".toCharArray(),
                "8........".toCharArray(),
                "9........".toCharArray()
        };

        new _36_Valid_Sudoku().isValidSudoku(board);
    }

    private boolean isValid(char c, Set<Character> st) {
        if (Character.isDigit(c) && st.contains(c)) {
            return false;
        } else {
            st.add(c);
            return true;
        }
    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (!isValid(board[i][j], rowSet) || !isValid(board[j][i], colSet)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Character> set = new HashSet<>();
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (!isValid(board[i * 3 + m][j * 3 + n], set)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
