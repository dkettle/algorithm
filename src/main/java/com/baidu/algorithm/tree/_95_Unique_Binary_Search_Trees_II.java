/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _95_Unique_Binary_Search_Trees_II
 *
 * @author xuhaoran01
 */
public class _95_Unique_Binary_Search_Trees_II {

    private List<TreeNode> generateTrees(int start, int end) {

        List<TreeNode> res = new ArrayList<>();

        if (start > end) {
            res.add(null);
        } else {
            for (int i = start; i <= end; i++) {

                List<TreeNode> lChild = generateTrees(start, i - 1);
                List<TreeNode> rChild = generateTrees(i + 1, end);

                for (TreeNode left : lChild) {
                    for (TreeNode right : rChild) {

                        TreeNode node = new TreeNode(i);
                        node.left = left;
                        node.right = right;

                        res.add(node);
                    }
                }
            }
        }

        return res;
    }

    public List<TreeNode> generateTrees(int n) {

        if (n < 1) {
            return new ArrayList<>();
        }

        return generateTrees(1, n);
    }
}
