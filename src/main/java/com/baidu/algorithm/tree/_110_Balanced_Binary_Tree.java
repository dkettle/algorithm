/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _110_Balanced_Binary_Tree
 *
 * @author xuhaoran01
 */
public class _110_Balanced_Binary_Tree {

    private int isBalancedHelper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lRes = isBalancedHelper(root.left);
        int rRes = isBalancedHelper(root.right);

        if (lRes == -1 || rRes == -1 || Math.abs(lRes - rRes) > 1) {
            return -1;
        }

        return Integer.max(lRes, rRes) + 1;
    }

    public boolean isBalanced(TreeNode root) {

        return isBalancedHelper(root) != -1;
    }
}
