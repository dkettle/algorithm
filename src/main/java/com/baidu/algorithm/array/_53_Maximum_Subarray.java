/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _53_Maximum_Subarray
 *
 * @author xuhaoran01
 */
public class _53_Maximum_Subarray {

    public int maxSubArray(int[] nums) {

        int res = nums[0], cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            res = Math.max(res, cur);
        }

        return res;
    }
}
