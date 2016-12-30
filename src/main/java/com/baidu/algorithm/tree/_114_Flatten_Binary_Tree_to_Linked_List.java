/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.Stack;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _114_Flatten_Binary_Tree_to_Linked_List
 *
 * @author xuhaoran01
 */
public class _114_Flatten_Binary_Tree_to_Linked_List {

    public void flatten(TreeNode root) {

        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {

            TreeNode cur = st.pop();
            if (cur != null) {

                if (prev != null) {
                    prev.right = cur;
                }

                st.push(cur.right);
                st.push(cur.left);
                prev = cur;

                prev.left = prev.right = null;
            }
        }
    }
}
