/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _230_Kth_Smallest_Element_in_a_BST
 *
 * @author xuhaoran01
 */
public class _230_Kth_Smallest_Element_in_a_BST {

    private int k;

    public int kthSmallest(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int lVal = kthSmallest(node.left);
        --k;

        if (k < 0) {
            return lVal;
        } else if (k == 0) {
            return node.val;
        } else {
            return kthSmallest(node.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {

        this.k = k;
        return kthSmallest(root);
    }
}
