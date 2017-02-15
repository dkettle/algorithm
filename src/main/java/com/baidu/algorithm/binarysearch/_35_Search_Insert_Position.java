/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearch;

/**
 * _35_Search_Insert_Position
 *
 * @author xuhaoran01
 */
public class _35_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}
