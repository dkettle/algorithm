/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

import java.util.HashMap;
import java.util.Map;

/**
 * _781_Rabbits_in_Forest
 *
 * @author xuhaoran01
 */
public class _781_Rabbits_in_Forest {

    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        int res = 0;
        for (int ans : map.keySet()) {
            res += Math.ceil((double) map.get(ans) / (ans + 1)) * (ans + 1);
        }

        return res;
    }
}
