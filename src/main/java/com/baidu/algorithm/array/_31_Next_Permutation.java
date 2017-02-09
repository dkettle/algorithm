/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _31_Next_Permutation
 *
 * @author xuhaoran01
 */
public class _31_Next_Permutation {

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {

        for (int i = start, j = end; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }

        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
        }
        else {
            int j = i;
            while (j < nums.length && nums[j] > nums[i - 1]) {
                j++;
            }

            swap(nums, i - 1, j - 1);

            reverse(nums, i, nums.length - 1);
        }
    }

    public static void main(String[] args) {
        new _31_Next_Permutation().nextPermutation(new int[]{1, 2});
    }
}
