/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dfs;

import java.util.*;

/**
 * _140_Word_Break_II
 *
 * @author xuhaoran01
 */
public class _140_Word_Break_II {

    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> cache) {

        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        if (s.isEmpty()) {
            return new ArrayList<>(Arrays.asList(""));
        }

        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subRes = dfs(s.substring(word.length()), wordDict, cache);
                for (String sub : subRes) {
                    res.add(sub.isEmpty() ? word : word + " " + sub);
                }
            }
        }

        cache.put(s, res);

        return res;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }

        return dfs(s, wordDict, new HashMap<>());
    }
}
