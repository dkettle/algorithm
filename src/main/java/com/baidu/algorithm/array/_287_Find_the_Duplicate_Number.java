/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _287_Find_the_Duplicate_Number
 *
 * @author xuhaoran01
 */
public class _287_Find_the_Duplicate_Number {

    // the array can be seen as an linked list: n[x] -> y. Now since integer cannot be 0, item 0 is guarenteed to be
    // a "node" outside any cycle because n[x] must be larger than 0, item 0 can be treated as head node
    public int findDuplicate(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return -1;
        }

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}
