/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.ListNode;
import com.baidu.algorithm.TreeNode;

/**
 * _109_Convert_Sorted_List_to_Binary_Search_Tree
 *
 * @author xuhaoran01
 */
public class _109_Convert_Sorted_List_to_Binary_Search_Tree {

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode prev = null, slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);

        if (prev != null) {
            prev.next = null;
            root.left = sortedListToBST(head);
        }

        return root;
    }
}
