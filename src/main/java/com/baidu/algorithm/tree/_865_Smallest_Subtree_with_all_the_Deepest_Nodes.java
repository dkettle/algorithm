/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeNode;

/**
 * _865_Smallest_Subtree_with_all_the_Deepest_Nodes
 *
 * @author xuhaoran01
 */
public class _865_Smallest_Subtree_with_all_the_Deepest_Nodes {

    private Node dfs(TreeNode root) {
        if (root == null) {
            return new Node(null, 0);
        }

        Node l = dfs(root.left),
                r = dfs(root.right);

        if (l.depth > r.depth) {
            return new Node(l.node, l.depth + 1);
        } else if (l.depth < r.depth) {
            return new Node(r.node, r.depth + 1);
        } else {
            return new Node(root, l.depth + 1);
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
}

class Node {
    public TreeNode node;
    public int depth;

    public Node(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}