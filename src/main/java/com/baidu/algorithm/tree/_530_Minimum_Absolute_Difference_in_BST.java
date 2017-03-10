/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.Stack;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _530_Minimum_Absolute_Difference_in_BST
 *
 * @author xuhaoran01
 */
public class _530_Minimum_Absolute_Difference_in_BST {

    public int getMinimumDifference(TreeNode root) {

        int res = Integer.MAX_VALUE;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode cur = stack.pop();
            if (prev != null) {
                res = Math.min(res, cur.val - prev.val);
            }

            prev = cur;
            root = cur.right;
        }

        return res;
    }
}
