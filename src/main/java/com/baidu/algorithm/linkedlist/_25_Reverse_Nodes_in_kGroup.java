/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.datastructure.ListNode;

/**
 * _25_Reverse_Nodes_in_kGroup
 *
 * @author xuhaoran01
 */
public class _25_Reverse_Nodes_in_kGroup {

    private ListNode reverseListHelper(ListNode head, ListNode newHead) {

        if (head == null) {
            return newHead;
        }

        ListNode next = head.next;
        head.next = newHead;

        return reverseListHelper(next, head);
    }

    private ListNode reverseList(ListNode head) {

        return reverseListHelper(head, null);
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0), tail = dummy;

        while (head != null) {

            ListNode prev = head, current = head.next;
            int count = 1;
            while (count < k && current != null) {
                prev = current;
                current = current.next;
                count++;
            }

            if (count < k) {
                tail.next = head;
                break;
            } else {
                prev.next = null;
                tail.next = reverseList(head);
                head = current;

                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }

        return dummy.next;
    }
}
