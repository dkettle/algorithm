/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * _889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal
 *
 * @author xuhaoran01
 */
public class _889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {

    private TreeNode constructFromPrePost(int[] pre, int s1, int e1, int[] post, int s2, int e2) {
        if (s1 > e1) {
            return null;
        } else if (s1 == e1) {
            return new TreeNode(pre[s1]);
        }

        int i = s1 + 1, j = s2;
        for (; j < e2; i++, j++) {
            if (post[j] == pre[s1 + 1]) {
                break;
            }
        }

        TreeNode root = new TreeNode(pre[s1]);
        root.left = constructFromPrePost(pre, s1 + 1, i, post, s2, j);
        root.right = constructFromPrePost(pre, i + 1, e1, post, j + 1, e2 - 1);

        return root;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || pre.length != post.length) {
            return null;
        }

        return constructFromPrePost(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    public static void main(String[] args) {
        new _889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal().constructFromPrePost(
                new int[]{1, 2, 4, 5, 3, 6, 7},
                new int[]{4, 5, 2, 6, 7, 3, 1}
        );
    }
}
