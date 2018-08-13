/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _517_Super_Washing_Machines
 *
 * @author xuhaoran01
 */
public class _517_Super_Washing_Machines {
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) {
            return 0;
        }

        int n = machines.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + machines[i];
        }

        if (sum[n] % n != 0) {
            return -1;
        }

        int avg = sum[n] / n, res = 0;
        for (int i = 1; i <= n; i++) {
            int lCnt = sum[i - 1] - avg * (i - 1);
            int rCnt = sum[n] - sum[i] - avg * (n - i);
            if (lCnt > 0 && rCnt > 0) {
                res = Math.max(res, Math.max(lCnt, rCnt));
            } else if (lCnt < 0 && rCnt < 0) {
                res = Math.max(res, -lCnt - rCnt);
            } else {
                res = Math.max(res, Math.max(Math.abs(lCnt), Math.abs(rCnt)));
            }
        }

        return res;
    }
}
