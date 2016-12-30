/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeLinkNode;
import com.baidu.algorithm.util.Utils;

/**
 * _117_Populating_Next_Right_Pointers_in_Each_Node_II
 *
 * @author xuhaoran01
 */
public class _117_Populating_Next_Right_Pointers_in_Each_Node_II {

    public void connect1(TreeLinkNode root) {

        TreeLinkNode cur = root, next = null;

        while (cur != null) {

            while (next == null && cur != null) {
                if (cur.left != null) {
                    next = cur.left;
                } else if (cur.right != null) {
                    next = cur.right;
                } else {
                    cur = cur.next;
                }
            }

            if (next == null) {
                return;
            }

            TreeLinkNode node = next;
            while (cur != null) {

                if (cur.left != null && cur.left != node) {
                    node.next = cur.left;
                    node = node.next;
                }

                if (cur.right != null && cur.right != node) {
                    node.next = cur.right;
                    node = node.next;
                }

                cur = cur.next;
            }

            cur = next;
            next = null;
        }
    }

    // concise
    public void connect(TreeLinkNode root) {

        TreeLinkNode dummy = new TreeLinkNode(0), tail = dummy, cur = root;

        while (cur != null) {

            while (cur != null) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }

                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }

                cur = cur.next;
            }

            cur = dummy.next;
            tail = dummy;
            tail.next = null;
        }
    }

    public static void main(String[] args) {

        TreeLinkNode root = Utils.buildLinkTree(1, 2, -1);
        new _117_Populating_Next_Right_Pointers_in_Each_Node_II().connect(root);
    }
}
