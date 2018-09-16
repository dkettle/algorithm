/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _495_Teemo_Attacking
 *
 * @author xuhaoran01
 */
public class _495_Teemo_Attacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }

        int res = duration;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            res += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }

        return res;
    }
}
