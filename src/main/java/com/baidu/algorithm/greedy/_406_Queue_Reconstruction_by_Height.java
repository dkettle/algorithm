/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _406_Queue_Reconstruction_by_Height
 *
 * @author xuhaoran01
 */
public class _406_Queue_Reconstruction_by_Height {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(people, (x, y) -> {
            if (x[0] != y[0]) {
                return y[0] - x[0];
            } else {
                return x[1] - y[1];
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }

        return res.toArray(new int[0][0]);
    }
}
