/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

import com.baidu.algorithm.datastructure.RandomListNode;

/**
 * _138_Copy_List_with_Random_Pointer
 *
 * @author xuhaoran01
 */
public class _138_Copy_List_with_Random_Pointer {

    public RandomListNode copyRandomList1(RandomListNode head) {

        if (head == null) {
            return null;
        }

        // origin, copy
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0), tail = dummy, current = head;

        while (current != null) {
            map.put(current, new RandomListNode(current.label));
            current = current.next;
        }

        while (head != null) {

            if (head.next != null) {
                map.get(head).next = map.get(head.next);
            }
            if (head.random != null) {
                map.get(head).random = map.get(head.random);
            }

            head = head.next;
        }

        return dummy.next;
    }

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }

        RandomListNode current = head, dummy = new RandomListNode(0), tail = dummy;
        while (current != null) {

            RandomListNode next = current.next;

            RandomListNode node = new RandomListNode(current.label);
            node.next = next;
            current.next = node;

            current = next;
        }

        current = head;
        while (current != null) {

            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        while (head != null) {
            tail.next = head.next;
            tail = tail.next;

            head.next = tail.next;
            head = head.next;
        }

        tail.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {

        RandomListNode node1 = new RandomListNode(-1);
        RandomListNode node2 = new RandomListNode(8);
        RandomListNode node3 = new RandomListNode(7);
        RandomListNode node4 = new RandomListNode(-3);
        RandomListNode node5 = new RandomListNode(4);

        node1.next = node2;
        node1.random = node5;

        node2.next = node3;
        node2.random = node4;

        node3.next = node4;
        node4.next = node5;

        node5.random = node1;

        new _138_Copy_List_with_Random_Pointer().copyRandomList(node1);
    }
}
