/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.twopointer;

import java.util.Arrays;

/**
 * _532_Kdiff_Pairs_in_an_Array
 *
 * @author xuhaoran01
 */
public class _532_Kdiff_Pairs_in_an_Array {

    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);

        int i = 0, j = 1, res = 0;
        while (j < nums.length && nums[j] - nums[i] < k) {
            j++;
        }

        while (j < nums.length) {
            if (i >= j) {
                j++;
            }
            else if (nums[j] - nums[i] == k) {
                res++;
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
                i++;
            }
            else if (nums[j] - nums[i] < k) {
                j++;
            }
            else {
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _532_Kdiff_Pairs_in_an_Array().findPairs(new int[]{3, 1, 4, 1, 5}, 2));;
    }
}
