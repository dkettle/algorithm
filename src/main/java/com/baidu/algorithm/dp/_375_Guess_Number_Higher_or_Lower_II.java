/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _375_Guess_Number_Higher_or_Lower_II
 *
 * @author xuhaoran01
 */
public class _375_Guess_Number_Higher_or_Lower_II {

    /**
     *
     *
     Definition of dp[i][j]: minimum number of money to guarantee win for subproblem [i, j].

     Target: dp[1][n]

     Corner case: dp[i][i] = 0 (because the only element must be correct)

     Equation: we can choose k (i<=k<=j) as our guess, and pay price k. After our guess, the problem is divided into two subproblems.
     Notice we do not need to pay the money for both subproblems. We only need to pay the worst case (because the system will tell us which side we should go) to guarantee win.
     So dp[i][j] = min (i<=k<=j) { k + max(dp[i][k-1], dp[k+1][j]) }
     */
    public int getMoneyAmount(int n) {

        int[][] dp = new int[n + 1][n + 1];

        for (int diff = 1; diff < n; diff++) {
            for (int i = 1; i + diff <= n; i++) {
                int j = i + diff;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = k + Math.min(dp[i][j],
                            Math.max(k > i ? dp[i][k - 1] : 0, k < j ? dp[k + 1][j] : 0));
                }
            }
        }

        return dp[1][n];
    }
}
