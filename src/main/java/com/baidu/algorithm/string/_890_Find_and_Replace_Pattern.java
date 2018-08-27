/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * _890_Find_and_Replace_Pattern
 *
 * @author xuhaoran01
 */
public class _890_Find_and_Replace_Pattern {

    private boolean match(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }

        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c1 = word.charAt(i), c2 = pattern.charAt(i);
            if (m1.containsKey(c1) && m2.containsKey(c2)) {
                if (m1.get(c1) != c2 || m2.get(c2) != c1) {
                    return false;
                }
            } else if (m1.containsKey(c1) || m2.containsKey(c2)) {
                return false;
            }

            m1.put(c1, c2);
            m2.put(c2, c1);
        }

        return true;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }

        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }

        return res;
    }
}
