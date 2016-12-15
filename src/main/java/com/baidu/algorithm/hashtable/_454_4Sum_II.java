/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * _454_4Sum_II
 *
 * @author xuhaoran01
 */
public class _454_4Sum_II {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int res = 0;

        Map<Integer, Integer> mp = new HashMap<>();
        Arrays.stream(A).forEach(x -> {
            Arrays.stream(B).forEach(y -> mp.put(x + y, mp.getOrDefault(x + y, 0) + 1));
        });

        for (int x : C) {
            for (int y : D) {
                res += mp.getOrDefault(- x - y, 0);
            }
        }

        return res;
    }
}
