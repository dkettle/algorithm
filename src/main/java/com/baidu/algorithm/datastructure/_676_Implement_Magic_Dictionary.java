/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

/**
 * _676_Implement_Magic_Dictionary
 *
 * @author xuhaoran01
 */
public class _676_Implement_Magic_Dictionary {

    class MagicDictionary {

        public TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {
            root = new TrieNode();
        }

        /**
         * Build a dictionary through a list of words
         */
        public void buildDict(String[] dict) {
            for (String word : dict) {
                TrieNode cur = root;
                for (int i = 0; i < word.length(); i++) {
                    int j = word.charAt(i) - 'a';
                    if (cur.child[j] == null) {
                        cur.child[j] = new TrieNode();
                    }

                    cur = cur.child[j];
                }

                cur.isLeaf = true;
            }
        }

        /**
         * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
         */
        public boolean search(String word) {
            return search(root, word, 0, false);
        }

        private boolean search(TrieNode cur, String word, int pos, boolean modify) {
            if (pos == word.length()) {
                return modify && cur.isLeaf;
            }

            int j = word.charAt(pos) - 'a';
            if (modify) {
                return cur.child[j] != null && search(cur.child[j], word, pos + 1, true);
            } else {
                for (int i = 0; i < 26; i++) {
                    if (cur.child[i] != null) {
                        if (i == j && search(cur.child[i], word, pos + 1, false)) {
                            return true;
                        }

                        if (i != j && search(cur.child[i], word, pos + 1, true)) {
                            return true;
                        }
                    }
                }

                return false;
            }
        }
    }

    class TrieNode {
        public boolean isLeaf;
        public TrieNode[] child;

        public TrieNode() {
            child = new TrieNode[26];
        }
    }

    public static void main(String[] args) {

    }
}
