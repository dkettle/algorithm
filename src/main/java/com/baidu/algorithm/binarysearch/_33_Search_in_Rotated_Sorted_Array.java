/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearch;

/**
 * _33_Search_in_Rotated_Sorted_Array
 *
 * @author xuhaoran01
 */
public class _33_Search_in_Rotated_Sorted_Array {

    private int search(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (end - start) / 2 + start;
        if (nums[mid] == target) {
            return mid;
        }
        else if (nums[mid] >= nums[start]) {
            if (target >= nums[start] && target < nums[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        else {
            if (target > nums[mid] && target <= nums[end]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

       return search(nums, start, end, target);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        return search(nums, 0, nums.length - 1, target);
    }

    public static void main(String[] args) {
        new _33_Search_in_Rotated_Sorted_Array().search(new int[]{3, 1}, 1);
    }
}
