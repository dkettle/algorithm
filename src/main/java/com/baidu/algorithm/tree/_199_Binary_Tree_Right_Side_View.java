/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _199_Binary_Tree_Right_Side_View
 *
 * @author xuhaoran01
 */
public class _199_Binary_Tree_Right_Side_View {

    // iterate
    public List<Integer> rightSideView1(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int sz = queue.size(), val = 0;

            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();

                val = cur.val;

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            res.add(val);
        }

        return res;
    }

    // recursive
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        rightSideViewHelper(root, res, 0);

        return res;
    }

    private void rightSideViewHelper(TreeNode node, List<Integer> res, int depth) {

        if (node != null) {

            if (depth == res.size()) {
                res.add(node.val);
            }

            rightSideViewHelper(node.right, res, depth + 1);
            rightSideViewHelper(node.left, res, depth + 1);
        }
    }
}
