/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.datastructure.ListNode;

/**
 * _83_Remove_Duplicates_from_Sorted_List
 *
 * @author xuhaoran01
 */
public class _83_Remove_Duplicates_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE), tail = dummy;
        while (head != null) {
            if (head.val > tail.val) {
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }

        tail.next = null;
        return dummy.next;
    }
}
