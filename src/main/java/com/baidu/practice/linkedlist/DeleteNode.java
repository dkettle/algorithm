/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.linkedlist;

import com.baidu.practice.model.LinkedList;
import com.baidu.practice.util.LinkedListFactory;

/**
 * DeleteNode
 *
 * @author xuhaoran01
 */
public class DeleteNode {

    public void deleteNode(LinkedList node) {
        if (node == null) {
            return;
        } else if (node.next == null) { // 实际上尾节点并没有被删除
            node = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        LinkedList node = LinkedListFactory.buildLinkedList(new int[]{1, 2, 3});

        new DeleteNode().deleteNode(node.next.next);

        LinkedListFactory.printLinkedList(node);
    }
}
