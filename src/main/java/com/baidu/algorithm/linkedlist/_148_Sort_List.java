/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.ListNode;

/**
 * _148_Sort_List
 *
 * @author xuhaoran01
 */
public class _148_Sort_List {

    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        while (l1 != null) {
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }

        while (l2 != null) {
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = sortList(slow.next);
        slow.next = null;

        ListNode l2 = sortList(head);

        return merge(l1, l2);
    }
}
