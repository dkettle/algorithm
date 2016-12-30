/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal
 *
 * @author xuhaoran01
 */
public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    private TreeNode buildTree(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2) {

        if (s1 > e1) {
            return null;
        }

        int val = postorder[e2], index = s1;
        while (inorder[index] != val) {
            index++;
        }

        TreeNode node = new TreeNode(val);
        node.left = buildTree(inorder, s1, index - 1, postorder, s2, index - 1 - s1 + s2);
        node.right = buildTree(inorder, index + 1, e1, postorder, index + e2 - e1, e2 - 1);

        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static void main(String[] args) {

        int[] in = {1, 2};
        int[] post = {2, 1};
        new _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal().buildTree(in, post);
    }
}
