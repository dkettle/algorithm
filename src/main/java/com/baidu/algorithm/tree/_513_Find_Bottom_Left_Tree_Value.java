/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _513_Find_Bottom_Left_Tree_Value
 *
 * @author xuhaoran01
 */
public class _513_Find_Bottom_Left_Tree_Value {

    class Pair {
        int height, val;

        public Pair(int h, int v) {
            this.height = h;
            this.val = v;
        }
    }

    private Pair helper(TreeNode root) {

        if (root == null) {
            return new Pair(0, -1);
        } else if (root.left == null && root.right == null) {
            return new Pair(1, root.val);
        } else if (root.left == null) {
            Pair p = helper(root.right);
            return new Pair(p.height + 1, p.val);
        } else if (root.right == null) {
            Pair p = helper(root.left);
            return new Pair(p.height + 1, p.val);
        } else {
            Pair p1 = helper(root.left);
            Pair p2 = helper(root.right);

            return p1.height >= p2.height ? new Pair(p1.height + 1, p1.val) : new Pair(p2.height + 1, p2.val);
        }
    }

    public int findBottomLeftValue(TreeNode root) {

        return helper(root).val;
    }

    int ans = 0, h = 0;

    public int findLeftMostNode(TreeNode root) {
        findLeftMostNode(root, 1);
        return ans;
    }

    public void findLeftMostNode(TreeNode root, int depth) {
        if (h < depth) {
            ans = root.val;
            h = depth;
        }
        if (root.left != null) {
            findLeftMostNode(root.left, depth + 1);
        }
        if (root.right != null) {
            findLeftMostNode(root.right, depth + 1);
        }
    }
}
