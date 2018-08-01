/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.datastructure.ListNode;

/**
 * _61_Rotate_List
 *
 * @author xuhaoran01
 */
public class _61_Rotate_List {

//    private int getLength(ListNode head) {
//
//        int res = 0;
//        while (head != null) {
//            res++;
//            head = head.next;
//        }
//
//        return res;
//    }
//
//    public ListNode rotateRight(ListNode head, int k) {
//
//        int len = getLength(head);
//        if (head == null || head.next == null || k % len == 0) {
//            return head;
//        }
//
//        k = k % len;
//        ListNode curr = head, tail = head;
//        while (k > 0) {
//            tail = tail.next;
//            k--;
//        }
//
//        while (tail.next != null) {
//            curr = curr.next;
//            tail = tail.next;
//        }
//
//        tail.next = head;
//        head = curr.next;
//        curr.next = null;
//
//        return head;
//    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public ListNode rotateRight(ListNode head, int k) {
        int len = getLen(head);
        if (head == null || head.next == null || k % len == 0) {
            return head;
        }

        k = k % len;
        ListNode cur = head, tail = head;
        while (k > 0) {
            tail = tail.next;
            k--;
        }

        while (tail.next != null) {
            tail = tail.next;
            cur = cur.next;
        }

        tail.next = head;
        head = cur.next;
        cur.next = null;

        return head;
    }
}
