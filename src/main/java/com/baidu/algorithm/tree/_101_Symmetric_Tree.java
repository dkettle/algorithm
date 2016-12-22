/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.TreeNode;

/**
 * _101_Symmetric_Tree
 *
 * @author xuhaoran01
 */
public class _101_Symmetric_Tree {

    private boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        } else if(left == null || right == null) {
            return false;
        } else {
            return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }

    public boolean isSymmetric(TreeNode root) {

        return root == null || isSymmetric(root.left, root.right);
    }
}
