/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.Stack;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _173_Binary_Search_Tree_Iterator
 *
 * @author xuhaoran01
 */
public class _173_Binary_Search_Tree_Iterator {

    public class BSTIterator {

        Stack<TreeNode> st = new Stack<>();

        public BSTIterator(TreeNode root) {

            while (root != null) {
                st.push(root);
                root = root.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {

            return !st.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {

            TreeNode top = st.pop();
            int res = top.val;

            top = top.right;
            while (top != null) {
                st.push(top);
                top = top.left;
            }

            return res;
        }
    }
}
