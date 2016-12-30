/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _107_Binary_Tree_Level_Order_Traversal_II
 *
 * @author xuhaoran01
 */
public class _107_Binary_Tree_Level_Order_Traversal_II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int sz = deque.size();
            List<Integer> li = new ArrayList<>();

            for (int i = 0; i < sz; i++) {
                TreeNode cur = deque.poll();
                if (cur != null) {
                    li.add(cur.val);
                    deque.offer(cur.left);
                    deque.offer(cur.right);
                }
            }

            if (li.size() > 0) {
                res.add(li);
            }
        }

        Collections.reverse(res);
        return res;
    }
}
