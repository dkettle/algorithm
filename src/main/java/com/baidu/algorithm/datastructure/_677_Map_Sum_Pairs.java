/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

/**
 * _677_Map_Sum_Pairs
 *
 * @author xuhaoran01
 */
public class _677_Map_Sum_Pairs {
    class MapSum {

        private Trie trie;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            trie = new Trie();
        }

        public void insert(String key, int val) {
            trie.insert(key, val);
        }

        public int sum(String prefix) {
            return trie.sum(prefix);
        }
    }

    class TrieNode {
        public int val;
        public TrieNode[] child;

        public TrieNode() {
            child = new TrieNode[256];
        }
    }

    class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode cur = root;
            for (char c : key.toCharArray()) {
                if (cur.child[(int) c] == null) {
                    cur.child[(int) c] = new TrieNode();
                }

                cur = cur.child[(int) c];
            }

            cur.val = val;
        }

        public int sum(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                if (cur.child[(int) c] == null) {
                    cur = null;
                    break;
                }

                cur = cur.child[(int) c];
            }

            return sum(cur);
        }

        private int sum(TrieNode cur) {
            if (cur == null) {
                return 0;
            }

            int res = cur.val;
            for (int i = 0; i < 256; i++) {
                res += sum(cur.child[i]);
            }

            return res;
        }
    }
}
