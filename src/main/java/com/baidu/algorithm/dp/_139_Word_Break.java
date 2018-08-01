/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

import java.util.List;

/**
 * _139_Word_Break
 *
 * @author xuhaoran01
 */
public class _139_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.isEmpty()) {
            return true;
        }

        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                int k = i - word.length();
                if (k >= 0 && dp[k] && s.substring(k, i).equals(word)) {
                    dp[i] = true;
                }
            }
        }

        return dp[len];
    }
}
