/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _814_Binary_Tree_Pruning
 *
 * @author xuhaoran01
 */
public class _814_Binary_Tree_Pruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        return (root.val == 1 || root.left != null || root.right != null) ? root : null;
    }
}
