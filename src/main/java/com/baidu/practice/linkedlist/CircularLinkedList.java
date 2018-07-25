/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.linkedlist;

import com.baidu.practice.model.LinkedList;
import com.baidu.practice.util.LinkedListFactory;

/**
 * CircularLinkedList
 *
 * @author xuhaoran01
 */
public class CircularLinkedList {

    public LinkedList findBeginning(LinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedList slow = head, fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast && fast != null && fast.next != null);

        if (fast != null && fast.next != null) {
            fast = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }

        return null;
    }

    public static void main(String[] args) {
        LinkedList head = LinkedListFactory.buildCircular();

        System.out.println(new CircularLinkedList().findBeginning(head));
    }
}
