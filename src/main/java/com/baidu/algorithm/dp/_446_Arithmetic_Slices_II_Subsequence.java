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

    // T(i, d) denotes the total number of arithmetic subsequence slices ending at index i with difference d.
    @SuppressWarnings("unchecked")
    public int numberOfArithmeticSlices(int[] A) {

        int res = 0;
        Map<Integer, Integer>[] maps = new HashMap[A.length];

        for (int i = 0; i < A.length; i++) {
            maps[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                long d = (long) A[i] - A[j];
                if (d > Integer.MAX_VALUE || d < Integer.MIN_VALUE) {
                    continue;
                }

                int diff = (int) d;
                int x = maps[j].getOrDefault(diff, 0);
                int y = maps[i].getOrDefault(diff, 0);

                res += x;
                maps[i].put(diff, y + x + 1);
            }
        }

        return res;
    }
}
