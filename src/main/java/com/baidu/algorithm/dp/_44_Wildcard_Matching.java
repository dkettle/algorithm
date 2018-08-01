/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _44_Wildcard_Matching
 *
 * @author xuhaoran01
 */
public class _44_Wildcard_Matching {

    public boolean isMatch(String s, String p) {

        int sLen = s.length(), pLen = p.length(), pCnt = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                pCnt++;
            }
        }

        if (pCnt > sLen) {
            return false;
        }

        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        dp[0][0] = true;

        for (int i = 0; i < pLen; i++) {
            if (p.charAt(i) == '*') {
                dp[i + 1][0] = dp[i][0];
            }
        }

        for (int i = 0; i < pLen; i++) {
            for (int j = 0; j < sLen; j++) {
                char pc = p.charAt(i), sc = s.charAt(j);
                if (pc == sc || pc == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pc == '*') {
                    int k = 0;
                    while (k <= sLen && !dp[i][k]) {
                        k++;
                    }

                    while (k <= sLen) {
                        dp[i + 1][k] = true;
                        k++;
                    }

                    j = k;
                }
            }
        }

        return dp[pLen][sLen];
    }
}
