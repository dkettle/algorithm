/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _437_Path_Sum_III
 *
 * @author xuhaoran01
 */
public class _437_Path_Sum_III {

    private int res = 0;

    private void pathSum(TreeNode root, int sum, List<Integer> list) {

        if (root == null) {
            return;
        }

        list.add(root.val);
        for (int i = list.size() - 1, cur = 0; i >= 0; i--) {
            cur += list.get(i);
            if (cur == sum) {
                res++;
            }
        }

        pathSum(root.left, sum, list);
        pathSum(root.right, sum, list);
        list.remove(list.size() - 1);
    }

    public int pathSum(TreeNode root, int sum) {

        pathSum(root, sum, new ArrayList<>());

        return res;
    }
}
