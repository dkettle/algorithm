/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _508_Most_Frequent_Subtree_Sum
 *
 * @author xuhaoran01
 */
public class _508_Most_Frequent_Subtree_Sum {

    private Map<Integer, Integer> mp = new HashMap<>();

    private int treeSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lVal = treeSum(root.left);
        int rVal = treeSum(root.right);
        int sum = lVal + rVal + root.val;

        mp.put(sum, mp.getOrDefault(sum, 0) + 1);

        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {

        if (root == null) {
            return new int[0];
        }

        treeSum(root);

        int maxVal = 0;
        for (int v : mp.values()) {
            maxVal = Integer.max(maxVal, v);
        }

        List<Integer> res = new ArrayList<>();
        for (int key : mp.keySet()) {
            if (mp.get(key) == maxVal) {
                res.add(key);
            }
        }

        return res.stream().mapToInt(x -> x).toArray();
    }
}
