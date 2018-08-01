/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _90_Subsets_II
 *
 * @author xuhaoran01
 */
public class _90_Subsets_II {

    private void dfs(List<List<Integer>> res, List<Integer> curRes, int[] nums, int index) {
        res.add(new ArrayList<>(curRes));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            curRes.add(nums[i]);
            dfs(res, curRes, nums, i + 1);
            curRes.remove(curRes.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, 0);

        return res;
    }
}
