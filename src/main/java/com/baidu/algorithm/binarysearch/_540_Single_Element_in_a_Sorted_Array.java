/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearch;

/**
 * _540_Single_Element_in_a_Sorted_Array
 *
 * @author xuhaoran01
 */
public class _540_Single_Element_in_a_Sorted_Array {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
