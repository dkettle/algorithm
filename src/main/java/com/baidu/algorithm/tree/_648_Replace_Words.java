/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.List;

/**
 * _648_Replace_Words
 *
 * @author xuhaoran01
 */
public class _648_Replace_Words {

    class TrieNode {
        public String word;
        public TrieNode[] child;

        public TrieNode() {
            child = new TrieNode[26];
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new TrieNode();
                }

                cur = cur.child[c - 'a'];
            }

            cur.word = word;
        }

        public String search(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length() && cur.word == null; i++) {
                char c = word.charAt(i);
                if (cur.child[c - 'a'] == null) {
                    break;
                }

                cur = cur.child[c - 'a'];
            }

            return cur.word != null ? cur.word : word;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.isEmpty()) {
            return sentence;
        }

        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }

        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            if (sb.length() > 0) {
                sb.append(" ");
            }

            sb.append(trie.search(word));
        }

        return sb.toString();
    }
}
