/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * _403_Frog_Jump
 *
 * @author xuhaoran01
 */
public class _403_Frog_Jump {

    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return true;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        map.get(0).add(1);
        for (int stone : stones) {
            for (int step : map.get(stone)) {
                int reach = stone + step;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }

                if (map.containsKey(reach)) {
                    if (step > 1) {
                        map.get(reach).add(step - 1);
                    }
                    map.get(reach).add(step);
                    map.get(reach).add(step + 1);
                }
            }
        }

        return false;
    }
}
