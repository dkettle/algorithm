/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.twopointer;

/**
 * _27_Remove_Element
 *
 * @author xuhaoran01
 */
public class _27_Remove_Element {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0, j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            }
            else {
                i++;
            }
        }

        return i;
    }
}
