/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.TreeNode;

/**
 * _404_Sum_of_Left_Leaves
 *
 * @author xuhaoran01
 */
public class _404_Sum_of_Left_Leaves {

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {

        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null && isLeft) {
            return root.val;
        } else {
            return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {

        return sumOfLeftLeaves(root, false);
    }
}
