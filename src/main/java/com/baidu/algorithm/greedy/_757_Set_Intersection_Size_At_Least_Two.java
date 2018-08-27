/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.greedy;

import java.util.Arrays;

/**
 * _757_Set_Intersection_Size_At_Least_Two
 *
 * @author xuhaoran01
 */
public class _757_Set_Intersection_Size_At_Least_Two {
    public int intersectionSizeTwo(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // by end ascending, by start descending,
        Arrays.sort(intervals, (x, y) -> {
            if (x[1] != y[1]) {
                return x[1] - y[1];
            } else {
                return y[0] - x[0];
            }
        });

        int res = 0, left = -1, right = -1;
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                res += 2;
                left = interval[1] - 1;
                right = interval[1];
            } else if (interval[0] <= right && interval[0] > left) {
                res += 1;
                left = right;
                right = interval[1];
            }
        }

        return res;
    }
}
