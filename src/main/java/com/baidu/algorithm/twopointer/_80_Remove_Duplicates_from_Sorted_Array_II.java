/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.twopointer;

/**
 * _80_Remove_Duplicates_from_Sorted_Array_II
 *
 * @author xuhaoran01
 */
public class    _80_Remove_Duplicates_from_Sorted_Array_II {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int i = 1, j = 2;
        while (j < nums.length) {
            if (nums[j] > nums[i - 1]) {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }
        return i + 1;
    }
}
