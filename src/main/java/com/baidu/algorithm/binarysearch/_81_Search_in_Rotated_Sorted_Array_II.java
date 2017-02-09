/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearch;

/**
 * _81_Search_in_Rotated_Sorted_Array_II
 *
 * @author xuhaoran01
 */
public class _81_Search_in_Rotated_Sorted_Array_II {

    public boolean search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return true;
            }
            else if (nums[mid] > nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else if (nums[mid] < nums[left]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            else {
                left++;
            }
        }

        return false;
    }
}
