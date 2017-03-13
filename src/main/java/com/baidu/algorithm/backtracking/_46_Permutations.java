/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
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

    private void permute(List<List<Integer>> res, List<Integer> oneRes, int[] nums, int n) {

        if (n == 0) {
            res.add(new ArrayList<>(oneRes));
        }

        for (int i = 0; i < n; i++) {
            oneRes.add(nums[i]);

            swap(nums, i, n - 1);
            permute(res, oneRes, nums, n - 1);
            swap(nums, i, n - 1);

            oneRes.remove(oneRes.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        permute(res, new ArrayList<Integer>(), nums, nums.length);


        return res;
    }
}
