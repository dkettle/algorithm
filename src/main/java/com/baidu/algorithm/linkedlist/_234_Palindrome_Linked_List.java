/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.ListNode;
import com.baidu.algorithm.Utils;

/**
 * _234_Palindrome_Linked_List
 *
 * @author xuhaoran01
 */
public class _234_Palindrome_Linked_List {

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

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revHead = reverseList(slow.next);
        slow.next = null;

        while (head != null && revHead != null) {
            if (head.val != revHead.val) {
                return false;
            }

            head = head.next;
            revHead = revHead.next;
        }

        return true;
    }

    public static void main(String[] args) {

        ListNode head = Utils.buildListNode(1, 1, 2, 1);

        new _234_Palindrome_Linked_List().isPalindrome(head);
    }
}
