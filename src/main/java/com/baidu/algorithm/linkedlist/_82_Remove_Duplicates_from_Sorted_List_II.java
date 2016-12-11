/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.ListNode;
import com.baidu.algorithm.Utils;

/**
 * _82_Remove_Duplicates_from_Sorted_List_II
 *
 * @author xuhaoran01
 */
public class _82_Remove_Duplicates_from_Sorted_List_II {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0), tail = dummy;
        while (head != null) {
            ListNode next = head.next;

            if (next == null || next.val != head.val) {
                tail.next = head;
                tail = tail.next;
            } else {
                while (next != null && next.val == head.val) {
                    next = next.next;
                }
            }

            head = next;
        }

        tail.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = Utils.buildListNode(2, 1);
        new _82_Remove_Duplicates_from_Sorted_List_II().deleteDuplicates(head);
    }
}
