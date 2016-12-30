/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.Arrays;
import java.util.Collections;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _337_House_Robber_III
 *
 * @author xuhaoran01
 */
public class _337_House_Robber_III {

    private int rob(TreeNode root, boolean rob) {

        if (root == null) {
            return 0;
        }

        if (rob) {
            return root.val + rob(root.left, false) + rob(root.right, false);
        }
        else {
            int val1 = rob(root.left, true) + rob(root.right, true);
            int val2 = rob(root.left, true) + rob(root.right, false);
            int val3 = rob(root.left, false) + rob(root.right, true);
            int val4 = rob(root.left, false) + rob(root.right, false);

            return Collections.max(Arrays.asList(val1, val2, val3, val4));
        }
    }

    public int rob(TreeNode root) {

        return Integer.max(rob(root, true), rob(root, false));
    }
}
