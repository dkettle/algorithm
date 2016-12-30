/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import com.baidu.algorithm.datastructure.TreeLinkNode;

/**
 * _116_Populating_Next_Right_Pointers_in_Each_Node
 *
 * @author xuhaoran01
 */
public class _116_Populating_Next_Right_Pointers_in_Each_Node {

    public void connect(TreeLinkNode root) {

        TreeLinkNode cur = root, next = null;
        while (cur != null && cur.left != null) {
            next = cur.left;

            do {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }

                cur = cur.next;
            } while (cur != null);

            cur = next;
        }
    }
}
