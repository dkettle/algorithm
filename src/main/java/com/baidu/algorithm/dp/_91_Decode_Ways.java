/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _91_Decode_Ways
 *
 * @author xuhaoran01
 */
public class _91_Decode_Ways {

    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= len; i++) {

            char curr = s.charAt(i - 1);
            char prev = s.charAt(i - 2);

            if (curr == '0') {
                if (prev != '1' && prev != '2') {
                    return 0;
                }
                dp[i] = dp[i - 2];
                continue;
            }

            dp[i] = dp[i - 1];
            if (prev == '1' || (prev == '2' && curr <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[len];
    }
}
