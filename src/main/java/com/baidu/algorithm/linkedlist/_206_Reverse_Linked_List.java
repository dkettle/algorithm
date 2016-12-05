/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.ListNode;

/**
 * _206_Reverse_Linked_List
 *
 * @author xuhaoran01
 */
public class _206_Reverse_Linked_List {

    // iteratively
    public ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        while (head != null) {

            ListNode next = head.next;

            head.next = dummy.next;
            dummy.next = head;

            head = next;
        }

        return dummy.next;
    }

    // recursively
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        return reverseListHelper(head, null);
    }

    private ListNode reverseListHelper(ListNode next, ListNode head) {

        if (next == null) {
            return head;
        }

        ListNode temp = next.next;
        next.next = head;

        return reverseListHelper(temp, next);
    }
}
