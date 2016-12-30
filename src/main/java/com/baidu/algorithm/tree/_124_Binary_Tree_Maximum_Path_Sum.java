/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _124_Binary_Tree_Maximum_Path_Sum
 *
 * @author xuhaoran01
 */
public class _124_Binary_Tree_Maximum_Path_Sum {

    private int res = Integer.MIN_VALUE;

    public int maxPathSumHelper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int curVal = root.val;
        int leftVal = Integer.max(maxPathSumHelper(root.left), 0);
        int rightVal = Integer.max(maxPathSumHelper(root.right), 0);

        res = Integer.max(res, curVal + leftVal + rightVal);

        return curVal + Integer.max(leftVal, rightVal);
    }

    public int maxPathSum(TreeNode root) {

        maxPathSumHelper(root);

        return res;
    }
}
