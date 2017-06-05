/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _78_Subsets
 *
 * @author xuhaoran01
 */
public class _78_Subsets {

    private void dfs(List<List<Integer>> res, List<Integer> oneRes, int[] nums, int index) {

        res.add(new ArrayList<>(oneRes));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            oneRes.add(nums[i]);
            dfs(res, oneRes, nums, i + 1);
            oneRes.remove(oneRes.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        dfs(res, new ArrayList<>(), nums, 0);

        return res;
    }
}
