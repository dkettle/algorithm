/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.datastructure.ListNode;
import com.baidu.algorithm.util.Utils;

/**
 * _143_Reorder_List
 *
 * @author xuhaoran01
 */
public class _143_Reorder_List {

    private ListNode reverseListHelper(ListNode head, ListNode newHead) {

        if (head == null) {
            return newHead;
        }

        ListNode next = head.next;
        head.next = newHead;

        return reverseListHelper(next, head);
    }

    private ListNode reverstList(ListNode head) {

        return reverseListHelper(head, null);
    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revHead = reverstList(slow.next);
        slow.next = null;

        ListNode dummy = new ListNode(0), tail = dummy;
        while (head != null) {
            tail.next = head;
            tail = tail.next;
            head = head.next; // 必须先记录head.next, 否则下面就会丢失原来的head.next

            tail.next = revHead;
            tail = tail.next;
            if (revHead != null) {
                revHead = revHead.next;
            }
        }

        head = dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = Utils.buildListNode(1, 2, 3);
        new _143_Reorder_List().reorderList(head);
    }
}
