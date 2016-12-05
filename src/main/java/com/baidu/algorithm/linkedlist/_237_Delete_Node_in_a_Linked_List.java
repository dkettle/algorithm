/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.ListNode;

/**
 * _237_Delete_Node_in_a_Linked_List
 *
 * @author xuhaoran01
 */
public class _237_Delete_Node_in_a_Linked_List {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
