/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * _655_Print_Binary_Tree
 *
 * @author xuhaoran01
 */
public class _655_Print_Binary_Tree {

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    private void fillRes(List<List<String>> res, int idx, int start, int end, TreeNode node) {
        if (node == null) {
            return;
        }

        int mid = (start + end) / 2;
        res.get(idx).set(mid, String.valueOf(node.val));
        fillRes(res, idx + 1, start, mid - 1, node.left);
        fillRes(res, idx + 1, mid + 1, end, node.right);
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root != null) {
            int m = getDepth(root), n = (1 << m) - 1;
            for (int i = 0; i < m; i++) {
                List<String> t = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    t.add("");
                }

                res.add(t);
            }

            fillRes(res, 0, 0, n - 1, root);
        }


        return res;
    }
}
