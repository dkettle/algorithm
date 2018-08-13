/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _226_Invert_Binary_Tree
 *
 * @author xuhaoran01
 */
public class _226_Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode node = root.left;

        root.left = invertTree(root.right);
        root.right = invertTree(node);

        return root;
    }
}
