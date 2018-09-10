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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            long cur = Long.MIN_VALUE;
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.remove();
                if (node != null) {
                    cur = Math.max(cur, node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if (cur != Long.MIN_VALUE) {
                res.add((int) cur);
            }
        }

        return res;
    }
}
