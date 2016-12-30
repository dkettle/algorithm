/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _257_Binary_Tree_Paths
 *
 * @author xuhaoran01
 */
public class _257_Binary_Tree_Paths {

    private void binaryTreePaths(TreeNode node, List<String> res, String str) {

        if (node == null) {
            return;
        } else if (node.left == null && node.right == null) {
            res.add(str + node.val);
        } else {
            binaryTreePaths(node.left, res, str + node.val + "->");
            binaryTreePaths(node.right, res, str + node.val + "->");
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();
        binaryTreePaths(root, res, "");

        return res;
    }
}
