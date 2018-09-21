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
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                map1.put(a + b, map1.getOrDefault(a + b, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                map2.put(c + d, map2.getOrDefault(c + d, 0) + 1);
            }
        }

        int res = 0;
        for (int k1 : map1.keySet()) {
            if (map2.containsKey(-k1)) {
                res += map1.get(k1) * map2.get(-k1);
            }
        }

        return res;
    }
}
