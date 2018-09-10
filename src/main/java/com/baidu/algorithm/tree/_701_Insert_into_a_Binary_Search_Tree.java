/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _701_Insert_into_a_Binary_Search_Tree
 *
 * @author xuhaoran01
 */
public class _701_Insert_into_a_Binary_Search_Tree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
