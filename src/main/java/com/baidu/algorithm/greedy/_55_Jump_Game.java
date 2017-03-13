/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.greedy;

/**
 * _55_Jump_Game
 *
 * @author xuhaoran01
 */
public class _55_Jump_Game {

    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return true;
        }

        int maxFar = 0;
        for (int i = 0; i < nums.length; i++) {

            if (maxFar >= i) {
                maxFar = Math.max(maxFar, nums[i] + i);
                if (maxFar >= nums.length - 1) {
                    return true;
                }
            }
            else {
                return false;
            }
        }

        return false;
    }
}
