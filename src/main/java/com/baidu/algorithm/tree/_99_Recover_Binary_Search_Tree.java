/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.Stack;

import com.baidu.algorithm.TreeNode;

/**
 * _99_Recover_Binary_Search_Tree
 *
 * @author xuhaoran01
 */
public class _99_Recover_Binary_Search_Tree {

    public void recoverTree(TreeNode root) {

        TreeNode first = null, postFirst = null, second = null, prev = null;

        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {

            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();

            if (prev != null && prev.val > root.val) {
                if (first == null) {
                    first = prev;
                    postFirst = root;
                } else {
                    second = root;
                }
            }

            prev = root;
            root = root.right;
        }

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        } else if (first != null) {
            int temp = first.val;
            first.val = postFirst.val;
            postFirst.val = temp;
        }
    }
}
