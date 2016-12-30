/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _104_Maximum_Depth_of_Binary_Tree
 *
 * @author xuhaoran01
 */
public class _104_Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
