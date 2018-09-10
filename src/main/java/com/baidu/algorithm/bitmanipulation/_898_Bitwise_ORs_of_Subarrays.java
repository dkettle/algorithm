/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bitmanipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * _898_Bitwise_ORs_of_Subarrays
 *
 * @author xuhaoran01
 */
public class _898_Bitwise_ORs_of_Subarrays {

    public int subarrayBitwiseORs(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        cur.add(0);

        for (int x : A) {
            Set<Integer> next = new HashSet<>();
            for (int y : cur) {
                next.add(x | y);
            }
            next.add(x);

            cur = next;

            res.addAll(cur);
        }

        return res.size();
    }
}
