/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _222_Count_Complete_Tree_Nodes
 *
 * @author xuhaoran01
 */
public class _222_Count_Complete_Tree_Nodes {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftCnt = 1, rightCnt = 1;
        TreeNode leftSub = root.left, rightSub = root.right;

        while (leftSub != null) {
            leftCnt++;
            leftSub = leftSub.left;
        }

        while (rightSub != null) {
            rightCnt++;
            rightSub = rightSub.right;
        }

        if (leftCnt == rightCnt) {
            return (1 << leftCnt) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
