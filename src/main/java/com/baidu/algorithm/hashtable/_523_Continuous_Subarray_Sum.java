/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * _523_Continuous_Subarray_Sum
 *
 * @author xuhaoran01
 */
public class _523_Continuous_Subarray_Sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (k != 0) {
                curSum %= k;
            }

            if (map.containsKey(curSum)) {
                if (i - map.get(curSum) > 1) {
                    return true;
                }
            } else {
                map.put(curSum, i);
            }
        }

        return false;
    }
}
