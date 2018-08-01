/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _47_Permutations_II
 *
 * @author xuhaoran01
 */
public class _47_Permutations_II {

    private void permute(List<List<Integer>> res, List<Integer> curRes, int[] nums, int pos, boolean[] visited) {
        if (pos == nums.length) {
            res.add(new ArrayList<>(curRes));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }

                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }

                visited[i] = true;
                curRes.add(nums[i]);

                permute(res, curRes, nums, pos + 1, visited);

                curRes.remove(curRes.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        permute(res, new ArrayList<>(), nums, 0, visited);

        return res;
    }

    public static void main(String[] args) {
        new _47_Permutations_II().permuteUnique(new int[]{1, 1, 2});
    }
}
