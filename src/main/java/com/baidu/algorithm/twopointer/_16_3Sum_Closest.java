/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.twopointer;

import java.util.Arrays;
import java.util.Collections;

/**
 * _16_3Sum_Closest
 *
 * @author xuhaoran01
 */
public class _16_3Sum_Closest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int res = 0, diff = Integer.MAX_VALUE, n = nums.length;
        for (int i = 0; i < n - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < diff) {
                    res = sum;
                    diff = Math.abs(sum - target);

                    if (diff == 0) {
                        return res;
                    }
                }

                if (sum > target) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }

        return res;
    }
}
