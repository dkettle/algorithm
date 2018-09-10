/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * _894_All_Possible_Full_Binary_Trees
 *
 * @author xuhaoran01
 */
public class _894_All_Possible_Full_Binary_Trees {

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) {
            return res;
        } else if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        } else {
            for (int i = 1; i < N; i += 2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(N - i - 1);

                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(0);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }

            return res;
        }
    }
}
