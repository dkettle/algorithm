/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _10_Regular_Expression_Matching
 *
 * @author xuhaoran01
 */
public class _10_Regular_Expression_Matching {

    /**
     * two sub conditions:
     * 1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
     * 2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
     * dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
     * or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
     * or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     */

    // dp
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        } else if (s == null || p == null) {
            return false;
        }

        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        for (int i = 1; i < pLen; i++) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i - 1];
            }
        }

        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {
                char sc = s.charAt(i), pc = p.charAt(j);
                if (pc == '.' || pc == sc) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pc == '*') {
                    char ppc = p.charAt(j - 1);
                    if (ppc != '.' && ppc != sc) {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1] | dp[i + 1][j] | dp[i][j + 1];
                    }
                }
            }
        }


        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        new _10_Regular_Expression_Matching().isMatch("aab", "c*a*b");
    }
}
