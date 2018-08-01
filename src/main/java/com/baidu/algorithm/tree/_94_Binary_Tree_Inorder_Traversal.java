/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.baidu.algorithm.annotation.Note;
import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _94_Binary_Tree_Inorder_Traversal
 *
 * @author xuhaoran01
 */
// In order LNR
// Pre order NLR
// Post order LRN
public class _94_Binary_Tree_Inorder_Traversal {
    // Stack
    public List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);

            root = root.right;
        }

        return res;
    }

    // recursive
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            res.addAll(inorderTraversal(root.left));
            res.add(root.val);
            res.addAll(inorderTraversal(root.right));
        }

        return res;
    }
    // Morris Traversal
    @Note(desc = "Morris Traversal in order")
    public List<Integer> inorderTraversal(TreeNode root) {

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
                    prev.right = root;
                    root = root.left;
                } else {
                    prev.right = null;
                    res.add(root.val);
                    root = root.right;
                }
            }
        }


        return res;
    }
}
