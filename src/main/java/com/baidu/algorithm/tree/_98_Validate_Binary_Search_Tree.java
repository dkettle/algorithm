/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.Stack;

import com.baidu.algorithm.TreeNode;

/**
 * _98_Validate_Binary_Search_Tree
 *
 * @author xuhaoran01
 */
public class _98_Validate_Binary_Search_Tree {

    // iteration
    public boolean isValidBST1(TreeNode root) {

        Stack<TreeNode> st = new Stack<>();
        long last = Long.MIN_VALUE;
        while (root != null || !st.isEmpty()) {

            while (root != null) {
                st.push(root);
                root = root.left;
            }

            TreeNode cur = st.pop();
            if (last >= cur.val) {
                return false;
            }

            last = cur.val;
            root = cur.right;
        }

        return true;
    }

    // recursive
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }

        return root.val > min && root.val < max
                       && isValidBST(root.left, min, root.val)
                       && isValidBST(root.right, root.val, max);
    }
}
