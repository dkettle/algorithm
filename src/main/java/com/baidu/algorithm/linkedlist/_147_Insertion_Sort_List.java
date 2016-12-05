/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.ListNode;

/**
 * _147_Insertion_Sort_List
 *
 * @author xuhaoran01
 */
public class _147_Insertion_Sort_List {

    private void insert(ListNode dummy, ListNode node) {

        while (dummy.next != null && dummy.next.val < node.val) {
            dummy = dummy.next;
        }

        node.next = dummy.next;
        dummy.next = node;
    }

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while (head != null) {

            ListNode next = head.next;
            insert(dummy, head);
            head = next;
        }

        return dummy.next;
    }
}
