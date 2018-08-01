/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearch;

/**
 * _153_Find_Minimum_in_Rotated_Sorted_Array
 *
 * @author xuhaoran01
 */
public class _153_Find_Minimum_in_Rotated_Sorted_Array {

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return nums[left];
    }
}
