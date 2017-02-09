/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * _448_Find_All_Numbers_Disappeared_in_an_Array
 *
 * @author xuhaoran01
 */
public class _448_Find_All_Numbers_Disappeared_in_an_Array {

    private void swap(int[] num, int x, int y) {

        int temp = num[x];
        num[x] = num[y];
        num[y] = temp;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        for (int i = 0; i < nums.length; ) {
            if (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
            else {
                i++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
