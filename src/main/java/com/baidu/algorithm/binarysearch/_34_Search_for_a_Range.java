/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearch;

/**
 * _34_Search_for_a_Range
 *
 * @author xuhaoran01
 */
public class _34_Search_for_a_Range {

//    public int[] searchRange(int[] nums, int target) {
//
//        if (nums == null || nums.length == 0) {
//            return new int[]{-1, -1};
//        }
//
//        int left = 0, right = nums.length - 1;
//        while (left <= right) {
//            int mid = (right - left) / 2 + left;
//            if (nums[mid] == target) {
//
//                int lIdx = mid, rIdx = mid;
//                while (lIdx >= 0 && nums[lIdx] == target) {
//                    lIdx--;
//                }
//                while (rIdx < nums.length && nums[rIdx] == target) {
//                    rIdx++;
//                }
//
//                return new int[]{lIdx + 1, rIdx - 1};
//            }
//            else if (nums[mid] > target) {
//                right = mid - 1;
//            }
//            else {
//                left = mid + 1;
//            }
//        }
//
//        return new int[]{-1, -1};
//    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                int lext = mid, rext = mid;
                while (lext >= 0 && nums[lext] == target) {
                    lext--;
                }
                while (rext < nums.length && nums[rext] == target) {
                    rext++;
                }

                return new int[]{lext + 1, rext - 1};
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}
