/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _103_Binary_Tree_Zigzag_Level_Order_Traversal
 *
 * @author xuhaoran01
 */
public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int sz = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);

                    list.add(cur.val);
                }
            }

            if (!list.isEmpty()) {
                if (count % 2 == 0) {
                    Collections.reverse(list);
                }
                res.add(list);
            }
        }


        return res;
    }
}
