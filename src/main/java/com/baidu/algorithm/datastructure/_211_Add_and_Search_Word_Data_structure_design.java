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

}

class WordDictionary {

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new Node();
            }

            cur = cur.child[c - 'a'];
        }

        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
        return search(word, 0, root);
    }

    private boolean search(String word, int pos, Node cur) {

        if (pos == word.length()) {
            return cur.isWord;
        }

        char c = word.charAt(pos);
        if (c != '.') {
            if (cur.child[c - 'a'] == null) {
                return false;
            }
            return search(word, pos + 1, cur.child[c - 'a']);
        }
        else {
            for (int i = 0; i < 26; i++) {
                if (cur.child[i] != null && search(word, pos + 1, cur.child[i])) {
                    return true;
                }
            }

            return false;
        }
    }
}

class Node {
    public boolean isWord;
    public Node[] child;

    public Node() {
        isWord = false;
        child = new Node[26];
    }
}