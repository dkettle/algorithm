/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * _212_Word_Search_II
 *
 * @author xuhaoran01
 */
public class _212_Word_Search_II {

    class TrieNode {
        public boolean isWord;
        public String word;
        public TrieNode[] child;

        public TrieNode() {
            child = new TrieNode[26];
        }
    }

    class Trie {

        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {

            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new TrieNode();
                }

                cur = cur.child[c - 'a'];
            }

            cur.isWord = true;
            cur.word = word;
        }
    }

    private void dfs(char[][] board, boolean[][] visited, Set<String> st, TrieNode node, int x, int y) {

        if (node.isWord) {
            st.add(node.word);
        }

        visited[x][y] = true;

        for (int[] mov : new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}}) {
            int xPos = x + mov[0], yPos = y + mov[1];
            if (xPos >= 0 && xPos < board.length && yPos >= 0 && yPos < board[0].length &&
                    !visited[xPos][yPos]) {
                char c = board[xPos][yPos];
                if (node.child[c - 'a'] != null) {
                    dfs(board, visited, st, node.child[c - 'a'], xPos, yPos);
                }
            }
        }

        visited[x][y] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {

        if (board.length == 0 || board[0].length == 0 || words.length == 0) {
            return new ArrayList<>();
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> set = new HashSet<>();
        TrieNode root = trie.root;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (root.child[c - 'a'] != null) {
                    dfs(board, visited, set, root.child[c - 'a'], i, j);
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        new _212_Word_Search_II().findWords(new char[][]{{'a'}}, new String[]{"a"});
    }
}
