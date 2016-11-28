/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * _126_Word_Ladder_II
 *
 * @author xuhaoran01
 */
public class _126_Word_Ladder_II {

    private boolean isLegal(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }

    private void helper(List<Set<String>> set, String word, int index, List<List<String>> res, List<String> oneRes) {

        if (index < 0) {
            List<String> temp = new ArrayList<>(oneRes);
            Collections.reverse(temp);
            res.add(temp);
            return;
        }

        Set<String> current = set.get(index);
        for (String str : current) {
            if (isLegal(str, word)) {
                oneRes.add(str);
                helper(set, str, index - 1, res, oneRes);
                oneRes.remove(str);
            }
        }
    }

    private List<List<String>> helper(List<Set<String>> set, String word) {
        List<List<String>> res = new ArrayList<>();
        List<String> oneRes = new ArrayList<>();
        oneRes.add(word);

        helper(set, word, set.size() - 1, res, oneRes);

        return res;
    }

    // endWord exits in wordList
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

        List<List<String>> res = new ArrayList<>();
        if (beginWord == null || endWord == null) {
            return res;
        }

        List<Set<String>> temp = new ArrayList<>();

        Set<String> current = new HashSet<>();
        current.add(beginWord);
        temp.add(current);

        wordList.add(endWord);
        while (!current.isEmpty()) {
            Set<String> next = new HashSet<>();

            for (String str : current) {
                if (str.equals(endWord)) {
                    temp.remove(current);

                    return helper(temp, endWord);
                }

                char[] cArr = str.toCharArray();
                for (int i = 0; i < cArr.length; i++) {
                    char c = cArr[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == c) {
                            continue;
                        }

                        cArr[i] = j;
                        String s = new String(cArr);
                        if (wordList.contains(s)) {
                            next.add(s);
                            wordList.remove(s);
                        }
                        cArr[i] = c;
                    }
                }
            }

            temp.add(next);
            current = next;
        }


        return res;
    }

    public static void main(String[] args) {
        Set<String> st = new HashSet<>();
        st.add("hot");
        st.add("dot");
        st.add("dog");
        st.add("lot");
        st.add("log");

        new _126_Word_Ladder_II().findLadders("hit", "cog", st);
    }
}
