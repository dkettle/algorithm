/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _337_House_Robber_III
 *
 * @author xuhaoran01
 */
public class _337_House_Robber_III {

    // dp
    public int rob1(TreeNode root) {

        return rob(root, new HashMap<>());
    }

    public int rob(TreeNode root, Map<TreeNode, Integer> mp) {

        if (root == null) {
            return 0;
        }
        else if (mp.containsKey(root)) {
            return mp.get(root);
        }

        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left, mp) + rob(root.left.right, mp);
        }

        if (root.right != null) {
            val += rob(root.right.left, mp) + rob(root.right.right, mp);
        }

        int res = Integer.max(root.val + val, rob(root.left, mp) + rob(root.right, mp));

        mp.put(root, res);
        return res;
    }

    // recursive
    public int rob(TreeNode root) {

        int[] res = robHelper(root);

        return Integer.max(res[0], res[1]);
    }

    private int[] robHelper(TreeNode root) {

        if (root == null) {
            return new int[2];
        }

        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);

        int[] res = new int[2];
        res[0] = Integer.max(left[0], left[1]) + Integer.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
