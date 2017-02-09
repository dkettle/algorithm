/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.twopointer;

/**
 * _26_Remove_Duplicates_from_Sorted_Array
 *
 * @author xuhaoran01
 */
public class _26_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] > nums[i]) {
                nums[i + 1] = nums[j];
                i++;
            }

            j++;
        }

        return i + 1;
    }
}
