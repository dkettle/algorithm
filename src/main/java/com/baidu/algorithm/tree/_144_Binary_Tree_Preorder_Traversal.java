/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.baidu.algorithm.TreeNode;

/**
 * _144_Binary_Tree_Preorder_Traversal
 *
 * @author xuhaoran01
 */
// pre order NLR
public class _144_Binary_Tree_Preorder_Traversal {

    // recursive
    public List<Integer> preorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root != null) {
            res.add(root.val);
            res.addAll(preorderTraversal(root.left));
            res.addAll(preorderTraversal(root.right));
        }

        return res;
    }

    // stack iterate 1
    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                res.add(root.val);
                stack.push(root.right);
                root = root.left;
            }

            root = stack.pop();
        }

        return res;
    }

    // stack iterate 2
    public List<Integer> preorderTraversal3(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode cur = stack.pop();
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }

        return res;
    }

    // Morris Traversal
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                TreeNode prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    res.add(root.val);
                    prev.right = root;
                    root = root.left;
                } else {
                    prev.right = null;
                    root = root.right;
                }
            }
        }

        return res;
    }
}
