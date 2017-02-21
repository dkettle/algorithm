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
 * _515_Find_Largest_Value_in_Each_Tree_Row
 *
 * @author xuhaoran01
 */
public class _515_Find_Largest_Value_in_Each_Tree_Row {

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int sz = queue.size(), val = Integer.MIN_VALUE;
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                val = Math.max(val, cur.val);

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
}
