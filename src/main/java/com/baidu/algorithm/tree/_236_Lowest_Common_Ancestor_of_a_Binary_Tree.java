/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.baidu.algorithm.Classic;
import com.baidu.algorithm.Note;
import com.baidu.algorithm.TreeNode;

/**
 * _236_Lowest_Common_Ancestor_of_a_Binary_Tree
 *
 * @author xuhaoran01
 */
@Classic
public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    // recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode lres = lowestCommonAncestor(root.left, p, q);
        TreeNode rres = lowestCommonAncestor(root.right, p, q);

        if (lres != null && rres != null) {
            return root;
        } else if (lres != null) {
            return lres;
        } else {
            return rres;
        }
    }

    // iterative
    @Note(desc = "deque usage")
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode cur = deque.poll();
            if (cur.left != null) {
                deque.offer(cur.left);
                parent.put(cur.left, cur);
            }

            if (cur.right != null) {
                deque.offer(cur.right);
                parent.put(cur.right, cur);
            }
        }

        Set<TreeNode> ancestor = new HashSet<>();
        while (p != null) {
            ancestor.add(p);
            p = parent.get(p);
        }

        while (!ancestor.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }
}
