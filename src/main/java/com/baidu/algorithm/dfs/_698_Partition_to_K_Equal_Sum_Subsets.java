/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dfs;

/**
 * _698_Partition_to_K_Equal_Sum_Subsets
 *
 * @author xuhaoran01
 */
public class _698_Partition_to_K_Equal_Sum_Subsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        int n = nums.length;
        boolean[] visited = new boolean[n];

        return dfs(nums, visited, k, 0, 0, sum / k);
    }

    private boolean dfs(int[] nums, boolean[] visited, int k, int idx, int sum, int target) {
        if (k == 1) {
            return true;
        } else if (sum > target) {
            return false;
        } else if (sum == target) {
            return dfs(nums, visited, k - 1, 0, 0, target);
        }

        for (int i = idx; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums, visited, k, i + 1, sum + nums[i], target)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }
}
