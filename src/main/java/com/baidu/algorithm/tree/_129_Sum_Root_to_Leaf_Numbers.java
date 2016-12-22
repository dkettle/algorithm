/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.TreeNode;

/**
 * _129_Sum_Root_to_Leaf_Numbers
 *
 * @author xuhaoran01
 */
public class _129_Sum_Root_to_Leaf_Numbers {

    private int sumNumbers(TreeNode root, int cur) {

        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return cur * 10 + root.val;
        } else {
            int val = cur * 10 + root.val;
            return sumNumbers(root.left, val) + sumNumbers(root.right, val);
        }
    }

    public int sumNumbers(TreeNode root) {

        return sumNumbers(root, 0);
    }
}
