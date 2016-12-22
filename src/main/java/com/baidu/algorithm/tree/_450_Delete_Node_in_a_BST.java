/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.TreeNode;

/**
 * _450_Delete_Node_in_a_BST
 *
 * @author xuhaoran01
 */
public class _450_Delete_Node_in_a_BST {

    public TreeNode deleteNode1(TreeNode root, int key) {

        if (root == null) {
            return null;
        } else if (root.val == key) {

            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null) {
                if (root.left.right != null) {
                    TreeNode prev = root.left;
                    while(prev.right.right != null) {
                        prev = prev.right;
                    }
                    root.val = prev.right.val;
                    prev.right = prev.right.left;
                } else {
                    root.val = root.left.val;
                    root.left = deleteNode(root.left, root.left.val);
                }
            } else {
                if (root.right.left != null) {
                    TreeNode prev = root.right;
                    while(prev.left.left != null) {
                        prev = prev.left;
                    }
                    root.val = prev.left.val;
                    prev.left = prev.left.right;
                } else {
                    root.val = root.right.val;
                    root.right = deleteNode(root.right, root.right.val);
                }
            }

        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            // find the minimum value in the right subtree
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
