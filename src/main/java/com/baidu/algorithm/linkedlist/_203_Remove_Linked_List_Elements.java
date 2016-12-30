/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.datastructure.ListNode;

/**
 * _203_Remove_Linked_List_Elements
 *
 * @author xuhaoran01
 */
public class _203_Remove_Linked_List_Elements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0), tail = dummy;
        while (head != null) {
            ListNode next = head.next;
            if (head.val != val) {
                tail.next = head;
                tail = tail.next;
            }

            head = next;
        }

        tail.next = null;
        return dummy.next;
    }
}
