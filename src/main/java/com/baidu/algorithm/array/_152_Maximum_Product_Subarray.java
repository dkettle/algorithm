/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _152_Maximum_Product_Subarray
 *
 * @author xuhaoran01
 */
public class _152_Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {

        int res = nums[0], maxVal = nums[0], minVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxTemp = Math.max(nums[i], Math.max(maxVal * nums[i], minVal * nums[i]));
            int minTemp = Math.min(nums[i], Math.min(maxVal * nums[i], minVal * nums[i]));

            res = Math.max(res, maxTemp);

            maxVal = maxTemp;
            minVal = minTemp;
        }

        return res;
    }
}
