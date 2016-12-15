/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * _219_Contains_Duplicate_II
 *
 * @author xuhaoran01
 */
public class _219_Contains_Duplicate_II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {

            if (mp.containsKey(nums[i]) && i - mp.get(nums[i]) <= k) {
                return true;
            }

            mp.put(nums[i], i);
        }

        return false;
    }
}
