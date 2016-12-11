/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.ListNode;

/**
 * _19_Remove_Nth_Node_From_End_of_List
 *
 * @author xuhaoran01
 */
public class _19_Remove_Nth_Node_From_End_of_List {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy, tail = dummy;
        while (n > 0) {
            tail = tail.next;
            n--;
        }

        while (tail.next != null) {
            current = current.next;
            tail = tail.next;
        }

        current.next = current.next.next;
        return dummy.next;
    }
}
