/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.ListNode;

/**
 * _328_Odd_Even_Linked_List
 *
 * @author xuhaoran01
 */
public class _328_Odd_Even_Linked_List {

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = new ListNode(0), oddTail = odd;
        ListNode even = new ListNode(0), evenTail = even;
        while (head != null) {
            oddTail.next = head;
            oddTail = oddTail.next;

            head = head.next;
            evenTail.next = head;
            evenTail = evenTail.next;

            if (head != null) {
                head = head.next;
            }
        }

        oddTail.next = even.next;

        return odd.next;
    }
}
