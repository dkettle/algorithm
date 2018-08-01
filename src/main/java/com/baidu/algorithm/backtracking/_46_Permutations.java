/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * _46_Permutations
 *
 * @author xuhaoran01
 */
public class _46_Permutations {

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private void permute(List<List<Integer>> res, List<Integer> curRes, int[] nums, int pos) {
        if (pos == nums.length) {
            res.add(new ArrayList<>(curRes));
        } else {
            for (int i = pos; i < nums.length; i++) {
                swap(nums, i, pos);

                curRes.add(nums[pos]);
                permute(res, curRes, nums, pos + 1);
                curRes.remove(curRes.size() - 1);

                swap(nums, i, pos);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        permute(res, new ArrayList<>(), nums, 0);

        return res;
    }
}
