/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.baidu.algorithm.annotation.Note;
import com.baidu.algorithm.datastructure.TreeNode;
import com.baidu.algorithm.util.Utils;

/**
 * _145_Binary_Tree_Postorder_Traversal
 *
 * @author xuhaoran01
 */
public class _145_Binary_Tree_Postorder_Traversal {

    // stack 1
    @Note(desc = "stack 正好保存从根节点到叶节点所有节点")
    public List<Integer> postorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null, cur = root;

        while (cur != null || !st.isEmpty()) {

            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }

            cur = st.peek();
            if (cur.right != null && (prev == null || prev != cur.right)) {
                cur = cur.right;
            } else {
                prev = cur;
                res.add(st.pop().val);
                cur = null;
            }
        }

        return res;
    }

    // stack 2 NRL then reverse
    public List<Integer> postorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {

            TreeNode cur = st.pop();
            if (cur != null) {
                res.add(cur.val);
                st.push(cur.left);
                st.push(cur.right);
            }
        }

        Collections.reverse(res);
        return res;
    }

    // Morris Traversal NRL then reverse
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        TreeNode cur = root;
        while (cur != null) {

            if (cur.right == null) {
                res.add(cur.val);
                cur = cur.left;
            } else {
                TreeNode prev = cur.right;
                while (prev.left != null && prev.left != cur) {
                    prev = prev.left;
                }

                if (prev.left == null) {
                    prev.left = cur;
                    res.add(cur.val);
                    cur = cur.right;
                } else {
                    prev.left = null;
                    cur = cur.left;
                }
            }
        }

        Collections.reverse(res);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = Utils.buildTree(1, -1, 2);
        new _145_Binary_Tree_Postorder_Traversal().postorderTraversal(root);
    }
}
