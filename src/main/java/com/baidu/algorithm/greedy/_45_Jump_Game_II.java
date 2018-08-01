/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.greedy;

/**
 * _45_Jump_Game_II
 *
 * @author xuhaoran01
 */
public class _45_Jump_Game_II {

    public int jump(int[] nums) {

        int res = 0, maxFar = 0, edge = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxFar = Math.max(maxFar, nums[i] + i);
            if (i == edge) {
                edge = maxFar;
                res++;
            }
        }

        return res;
    }

}
