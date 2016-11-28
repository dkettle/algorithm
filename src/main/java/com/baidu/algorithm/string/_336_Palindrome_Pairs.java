/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * _336_Palindrome_Pairs
 *
 * @author xuhaoran01
 */
public class _336_Palindrome_Pairs {

    private boolean isPalindrome(String s) {

        String rStr = new StringBuilder(s).reverse().toString();

        return rStr.equals(s);
    }

    private String reverseStr(String s) {

        return new StringBuilder(s).reverse().toString();
    }

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> res = new ArrayList<>();

        if (words == null || words.length <= 1) {
            return res;
        }

        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            mp.put(words[i], i);
        }

        if (mp.get("") != null) {
            int i = mp.get("");
            for (int j = 0; j < words.length; j++) {
                if (i != j && isPalindrome(words[j])) {
                    res.add(Arrays.asList(i, j));
                    res.add(Arrays.asList(j, i));
                }
            }
        }

        for (int i = 0; i < words.length; i++) {

            String cur = words[i];

            Integer idx = mp.get(reverseStr(cur));
            if (idx != null && idx != i) {
                res.add(Arrays.asList(i, idx));
            }

            for (int j = 1; j < cur.length(); j++) {
                if (isPalindrome(cur.substring(j))) {
                    Integer index = mp.get(reverseStr(cur.substring(0, j)));
                    if (index != null && index != i) {
                        res.add(Arrays.asList(i, index));
                    }
                }

                if (isPalindrome(cur.substring(0, j))) {
                    Integer index = mp.get(reverseStr(cur.substring(j)));
                    if (index != null && index != i) {
                        res.add(Arrays.asList(index, i));
                    }
                }
            }
        }

        return res;
    }
}
