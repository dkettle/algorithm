/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.datastructure.ListNode;
import com.baidu.algorithm.util.Utils;

/**
 * _92_Reverse_Linked_List_II
 *
 * @author xuhaoran01
 */
public class _92_Reverse_Linked_List_II {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || head.next == null || m == n) {
            return head;
        }

        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;

        int count = 1;
        while (count < m) {
            prev = prev.next;
            count++;
        }

        ListNode curr = prev.next, retain = curr;
        prev.next = null;
        while (count <= n) {
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;

            curr = next;
            count++;
        }

        retain.next = curr;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = Utils.buildListNode(3, 5);
        new _92_Reverse_Linked_List_II().reverseBetween(head, 1, 2);
    }
}
