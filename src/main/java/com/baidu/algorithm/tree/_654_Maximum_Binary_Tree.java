/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _654_Maximum_Binary_Tree
 *
 * @author xuhaoran01
 */
public class _654_Maximum_Binary_Tree {
    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int idx = left, curMax = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > curMax) {
                curMax = nums[i];
                idx = i;
            }
        }

        TreeNode root = new TreeNode(nums[idx]);
        root.left = constructMaximumBinaryTree(nums, left, idx - 1);
        root.right = constructMaximumBinaryTree(nums, idx + 1, right);

        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
}
