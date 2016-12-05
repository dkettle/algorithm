/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.ListNode;

/**
 * _445_Add_Two_Numbers_II
 *
 * @author xuhaoran01
 */
public class _445_Add_Two_Numbers_II {

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

    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0), head = dummy;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            head.next = new ListNode(sum % 10);
            head = head.next;

            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            head.next = new ListNode(sum % 10);
            head = head.next;

            carry = sum / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            head.next = new ListNode(sum % 10);
            head = head.next;

            carry = sum / 10;
            l2 = l2.next;
        }

        if (carry > 0) {
            head.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        return reverseList(addTwoNumbersHelper(reverseList(l1), reverseList(l2)));
    }
}
