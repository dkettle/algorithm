/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _108_Convert_Sorted_Array_to_Binary_Search_Tree
 *
 * @author xuhaoran01
 */
public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (end - start) / 2 + start;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);

        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
}
