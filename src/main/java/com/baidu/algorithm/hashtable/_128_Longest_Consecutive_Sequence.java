/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * _128_Longest_Consecutive_Sequence
 *
 * @author xuhaoran01
 */
public class _128_Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num, curLen = 1;
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    curLen += 1;
                }

                res = Math.max(res, curLen);
            }
        }

        return res;
    }
}
