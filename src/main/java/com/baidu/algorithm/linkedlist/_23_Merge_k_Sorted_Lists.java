/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import java.util.PriorityQueue;

import com.baidu.algorithm.ListNode;
import com.baidu.algorithm.Note;

/**
 * _23_Merge_k_Sorted_Lists
 *
 * @author xuhaoran01
 */
public class _23_Merge_k_Sorted_Lists {

    @Note(desc = "PriorityQueue用法")
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        // 小根堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0), tail = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            tail.next = curr;
            tail = tail.next;

            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        return dummy.next;
    }
}
