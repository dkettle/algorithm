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

    public static void main(String[] args) {
        new _212_Word_Search_II().findWords(new char[][]{{'a'}}, new String[]{"oath","pea","eat","rain"});
    }

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

    private void dfs(TrieNode node, char[][] board, int px, int py, boolean[][] visited, Set<String> res) {
        if (node.isWord) {
            res.add(node.word);
        }

        if (px < 0 || px >= board.length || py < 0 || py >= board[0].length || visited[px][py] || node.child[board[px][py] - 'a'] == null) {
            return;
        }

        visited[px][py] = true;
        for (int[] mov : new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}}) {
            dfs(node.child[board[px][py] - 'a'], board, px + mov[0], py + mov[1], visited, res);
        }
        visited[px][py] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0 || words.length == 0) {
            return res;
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(trie.root, board, i, j, new boolean[board.length][board[0].length], set);
            }
        }

        return new ArrayList<>(set);
    }
}
