/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.ListNode;

/**
 * _142_Linked_List_Cycle_II
 *
 * @author xuhaoran01
 */
public class _142_Linked_List_Cycle_II {

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast && fast != null && fast.next != null);

        if (slow != fast) {
            return null;
        }

        while (slow != head) {
            slow = slow.next;
            head = head.next;
        }

        return slow;
    }
}
