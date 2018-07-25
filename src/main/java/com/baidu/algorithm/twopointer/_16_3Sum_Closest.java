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
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int res = 0, diff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int tmp = nums[i] + nums[j] + nums[k];

                if (Math.abs(tmp - target) < diff) {
                    diff = Math.abs(tmp - target);
                    res = tmp;
                }

                if (tmp == target) {
                    return res;
                }
                else if (tmp > target) {
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
