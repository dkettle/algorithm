/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

/**
 * _211_Add_and_Search_Word_Data_structure_design
 *
 * @author xuhaoran01
 */
public class _211_Add_and_Search_Word_Data_structure_design {
    class WordDictionary {

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new TrieNode();
                }

                cur = cur.child[c - 'a'];
            }

            cur.isWord = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return search(word, 0, root);
        }

        private boolean search(String word, int pos, TrieNode trie) {
            if (pos == word.length()) {
                return trie.isWord;
            }

            char c = word.charAt(pos);
            if (c != '.') {
                if (trie.child[c - 'a'] == null) {
                    return false;
                } else {
                    return search(word, pos + 1, trie.child[c - 'a']);
                }
            } else {
                for (int i = 0; i < 26; i++) {
                    if (trie.child[i] != null && search(word, pos + 1, trie.child[i])) {
                        return true;
                    }
                }

                return false;
            }
        }
    }

    class TrieNode {
        public boolean isWord;
        public TrieNode[] child;

        public TrieNode() {
            child = new TrieNode[26];
            isWord = false;
        }
    }
}