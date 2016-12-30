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
 * _102_Binary_Tree_Level_Order_Traversal
 *
 * @author xuhaoran01
 */
public class _102_Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    list.add(cur.val);
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }

            if (list.size() > 0) {
                res.add(list);
            }
        }

        return res;
    }
}
