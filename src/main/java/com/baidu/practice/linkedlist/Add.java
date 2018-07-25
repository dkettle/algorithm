/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.linkedlist;

import com.baidu.practice.model.LinkedList;
import com.baidu.practice.util.LinkedListFactory;

/**
 * Add
 *
 * @author xuhaoran01
 */
public class Add {

    public LinkedList add(LinkedList l1, LinkedList l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        LinkedList dummy = new LinkedList(-1), tail = dummy;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int v = l1.val + l2.val + carry;
            tail.next = new LinkedList(v % 10);
            tail = tail.next;

            carry = v / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int v = l1.val + carry;
            tail.next = new LinkedList(v % 10);
            tail = tail.next;

            carry = v / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int v = l2.val + carry;
            tail.next = new LinkedList(v % 10);
            tail = tail.next;

            carry = v / 10;
            l2 = l2.next;
        }

        if (carry > 0) {
            tail.next = new LinkedList(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList l1 = LinkedListFactory.buildLinkedList(new int[]{3, 1, 5});
        LinkedList l2 = LinkedListFactory.buildLinkedList(new int[]{5, 9, 2});

        LinkedList l3 = new Add().add(l1, l2);

        LinkedListFactory.printLinkedList(l1);
        System.out.println();
        LinkedListFactory.printLinkedList(l2);
        System.out.println();
        LinkedListFactory.printLinkedList(l3);
    }
}
