/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * _560_Subarray_Sum_Equals_K
 *
 * @author xuhaoran01
 */
public class _560_Subarray_Sum_Equals_K {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int curSum = 0, res = 0;
        for (int num : nums) {
            curSum += num;
            res += map.getOrDefault(curSum - k, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        return res;
    }
}
