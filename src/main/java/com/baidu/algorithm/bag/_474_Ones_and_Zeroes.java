/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bag;

/**
 * _474_Ones_and_Zeroes
 *
 * @author xuhaoran01
 */
public class _474_Ones_and_Zeroes {

    public int findMaxForm1(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }

        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];

                    String str = strs[i - 1];
                    int zero = 0, one = 0;
                    for (char c : str.toCharArray()) {
                        if (c == '0') {
                            zero++;
                        } else {
                            one++;
                        }
                    }

                    if (j >= zero && k >= one) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zero][k - one] + 1);
                    }
                }
            }
        }

        return dp[len][m][n];
    }

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }

        int len = strs.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    String str = strs[i - 1];
                    int zero = 0, one = 0;
                    for (char c : str.toCharArray()) {
                        if (c == '0') {
                            zero++;
                        } else {
                            one++;
                        }
                    }

                    if (j >= zero && k >= one) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                    }
                }
            }
        }

        return dp[m][n];
    }
}
