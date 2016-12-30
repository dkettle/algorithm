/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

import com.baidu.algorithm.datastructure.ListNode;

/**
 * _160_Intersection_of_Two_Linked_Lists
 *
 * @author xuhaoran01
 */
public class _160_Intersection_of_Two_Linked_Lists {

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                break;
            }
            headB = headB.next;
        }

        return headB;
    }

    private int getLength(ListNode head) {

        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }

        return res;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        int aLen = getLength(headA);
        int bLen = getLength(headB);

        while (aLen > bLen) {
            headA = headA.next;
            aLen--;
        }

        while (bLen > aLen) {
            headB = headB.next;
            bLen--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
