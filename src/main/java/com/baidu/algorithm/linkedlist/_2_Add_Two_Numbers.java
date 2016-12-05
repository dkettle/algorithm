/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.ListNode;

/**
 * _2_Add_Two_Numbers
 *
 * @author xuhaoran01
 */
public class _2_Add_Two_Numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

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
}
