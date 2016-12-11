/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.ListNode;

/**
 * _86_Partition_List
 *
 * @author xuhaoran01
 */
public class _86_Partition_List {

    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy1 = new ListNode(0), tail1 = dummy1;
        ListNode dummy2 = new ListNode(0), tail2 = dummy2;

        while (head != null) {
            ListNode next = head.next;
            if (head.val < x) {
                tail1.next = head;
                tail1 = tail1.next;
            } else {
                tail2.next = head;
                tail2 = tail2.next;
            }
            head = next;
        }

        tail1.next = dummy2.next;
        tail2.next = null;

        return dummy1.next;
    }
}
