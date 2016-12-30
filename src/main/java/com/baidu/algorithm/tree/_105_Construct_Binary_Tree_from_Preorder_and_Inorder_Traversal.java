/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal
 *
 * @author xuhaoran01
 */
public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    private TreeNode buildTree(int[] pre, int s1, int e1, int[] in, int s2, int e2) {

        if (s1 > e1) {
            return null;
        }

        int val = pre[s1], index = s2;
        while (in[index] != val) {
            index++;
        }

        TreeNode node = new TreeNode(val);
        node.left = buildTree(pre, s1 + 1, index - s2 + s1, in, s2, index - 1);
        node.right = buildTree(pre, e1 - e2 + index + 1, e1, in, index + 1, e2);

        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}
