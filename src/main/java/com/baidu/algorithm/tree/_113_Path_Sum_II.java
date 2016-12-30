/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _113_Path_Sum_II
 *
 * @author xuhaoran01
 */
public class _113_Path_Sum_II {

    private void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> oneRes) {

        if (root == null) {
            return;
        }

        oneRes.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(new ArrayList<>(oneRes));
            }
        } else {
            pathSum(root.left, sum - root.val, res, oneRes);
            pathSum(root.right, sum - root.val, res, oneRes);
        }
        oneRes.remove(oneRes.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> oneRes = new ArrayList<>();

        pathSum(root, sum, res, oneRes);

        return res;
    }
}
