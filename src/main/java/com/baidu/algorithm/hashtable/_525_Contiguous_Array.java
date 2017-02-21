/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * _525_Contiguous_Array
 *
 * @author xuhaoran01
 */
public class _525_Contiguous_Array {

    public int findMaxLength(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? -1 : 1;
        }

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (mp.containsKey(sum)) {
                res = Math.max(res, i - mp.get(sum));
            }
            else {
                mp.put(sum, i);
            }
        }

        return res;
    }
}
