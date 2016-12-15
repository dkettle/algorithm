/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.twopointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * _18_4Sum
 *
 * @author xuhaoran01
 */
public class _18_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        int len = nums.length;

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int m = j + 1, n = len - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        m++;
                        while (m < n && nums[m] == nums[m - 1]) {
                            m++;
                        }
                    } else if (sum > target) {
                        n--;
                    } else {
                        m++;
                    }
                }
            }
        }

        return res;
    }
}
