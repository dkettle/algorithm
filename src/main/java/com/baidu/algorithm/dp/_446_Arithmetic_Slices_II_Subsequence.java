/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * _446_Arithmetic_Slices_II_Subsequence
 *
 * @author xuhaoran01
 */
public class _446_Arithmetic_Slices_II_Subsequence {

    // T(i, d) denotes the total number of arithmetic subsequence slices (at least size 2) ending at index i with difference d.
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        int n = A.length, res = 0;
        Map<Integer, Integer>[] maps = new HashMap[n];
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue;
                }

                int d = (int) diff;
                int x = maps[j].getOrDefault(d, 0);

                res += x;

                maps[i].put(d, maps[i].getOrDefault(d, 0) + x + 1);
            }
        }

        return res;
    }
}
