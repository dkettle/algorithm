/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.util;

import com.baidu.practice.model.LinkedList;

/**
 * LinkedListFactory
 *
 * @author xuhaoran01
 */
public class LinkedListFactory {

    public static LinkedList buildCircular() {
        LinkedList head = new LinkedList(0), tail = head;
        for (int i = 1; i < 10; i++) {
            tail.next = new LinkedList(i);
            tail = tail.next;
        }

        tail.next = head.next.next;

        return head;
    }

    public static LinkedList buildLinkedList(int[] nums) {
        LinkedList head = new LinkedList(0), tail = head;
        for (int i : nums) {
            tail.next = new LinkedList(i);
            tail = tail.next;
        }

        return head.next;
    }

    public static void printLinkedList(LinkedList head) {
        for (int i = 0; i < 15 && head != null; i++) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}