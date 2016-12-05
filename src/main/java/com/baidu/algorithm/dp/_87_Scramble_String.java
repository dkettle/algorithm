/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _87_Scramble_String
 *
 * @author xuhaoran01
 */
public class _87_Scramble_String {

    public boolean isScramble(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];

        for (int k = 1; k <= n; k++) {
            for (int i = 0; i + k <= n; i++) {
                for (int j = 0; j + k <= n; j++) {
                    if (k == 1) {
                        dp[i][j][k] = s1.charAt(i) == s2.charAt(j) ? true : false;
                    }
                    else {
                        for (int t = 1; t < k; t++) {
                            if ((dp[i][j][t] && dp[i + t][j + t][k - t])
                                        || (dp[i][j + k - t][t] && dp[i + t][j][k - t])) {
                                dp[i][j][k] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return dp[0][0][n];
    }
}
