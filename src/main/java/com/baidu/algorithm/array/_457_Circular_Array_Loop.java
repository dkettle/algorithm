/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _457_Circular_Array_Loop
 *
 * @author xuhaoran01
 */
public class _457_Circular_Array_Loop {

    private int getNext(int[] nums, int i) {
        return (nums.length + nums[i] + i) % nums.length;
    }

    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }

            int slow = i, fast = i;
            while (nums[fast] * nums[i] > 0 && nums[getNext(nums, fast)] * nums[i] > 0) {
                slow = getNext(nums, slow);
                fast = getNext(nums, getNext(nums, fast));

                if (slow == fast) {
                    if (slow == getNext(nums, slow)) {
                        break;
                    }
                    return true;
                }
            }

            int j = i, v = nums[i];
            while (nums[j] * v > 0) {
                int nj = getNext(nums, j);
                nums[j] = 0;
                j = nj;
            }
        }

        return false;
    }
}
