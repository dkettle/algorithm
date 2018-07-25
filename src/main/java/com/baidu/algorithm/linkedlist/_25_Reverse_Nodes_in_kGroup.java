/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.datastructure.ListNode;
import com.baidu.algorithm.util.Utils;

/**
 * _25_Reverse_Nodes_in_kGroup
 *
 * @author xuhaoran01
 */
public class _25_Reverse_Nodes_in_kGroup {

//    private ListNode reverseListHelper(ListNode head, ListNode newHead) {
//
//        if (head == null) {
//            return newHead;
//        }
//
//        ListNode next = head.next;
//        head.next = newHead;
//
//        return reverseListHelper(next, head);
//    }
//
//    private ListNode reverseList(ListNode head) {
//
//        return reverseListHelper(head, null);
//    }
//
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode p = head.next;

            head.next = dummy.next;
            dummy.next = head;

            head = p;
        }

        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1), tail = dummy;
        while (head != null) {
            int n = 1;
            ListNode p = head;
            while (p != null && n < k) {
                p = p.next;
                n += 1;
            }

            if (p == null) {
                tail.next = head;
                head = null;
            }
            else {
                ListNode q = p.next;

                p.next = null;
                tail.next = reverseList(head);
                while (tail.next != null) {
                    tail = tail.next;
                }

                head = q;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = Utils.buildListNode(1, 2, 3);
        new _25_Reverse_Nodes_in_kGroup().reverseKGroup(head, 2);
    }
}
