/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _639_Decode_Ways_II
 *
 * @author xuhaoran01
 */
public class _639_Decode_Ways_II {
    int M = 1000000007;

    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;

        for (int i = 1; i < s.length(); i++) {
            char prev = s.charAt(i - 1), cur = s.charAt(i);
            if (cur == '*') {
                dp[i + 1] += dp[i] * 9 % M;
                if (prev == '1') {
                    dp[i + 1] += dp[i - 1] * 9 % M;
                } else if (prev == '2') {
                    dp[i + 1] += dp[i - 1] * 6 % M;
                } else if (prev == '*') {
                    dp[i + 1] += dp[i - 1] * 15 % M;
                }
            } else {
                dp[i + 1] = cur == '0' ? 0 : dp[i];
                if (prev == '1' || (prev == '2' && cur <= '6')) {
                    dp[i + 1] += dp[i - 1];
                } else if (prev == '*') {
                    dp[i + 1] += (cur <= '6' ? 2 : 1) * dp[i - 1] % M;
                }
            }
        }

        return (int) (dp[n] % M);
    }

    public static void main(String[] args) {
        new _639_Decode_Ways_II().numDecodings("********************");
    }
}
