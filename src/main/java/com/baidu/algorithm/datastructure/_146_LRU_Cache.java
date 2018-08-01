/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * _146_LRU_Cache
 *
 * @author xuhaoran01
 */
public class _146_LRU_Cache {

    class LRUCache {

        class Node {
            public int key;
            public int val;
            public Node next;
            public Node prev;

            public Node(int x, int y) {
                key = x;
                val = y;
            }
        }

        private Map<Integer, Node> key2Node;
        private int capacity;
        private int curSize;
        private Node head, tail;

        public LRUCache(int capacity) {
            key2Node = new HashMap<>();
            this.capacity = capacity;
            curSize = 0;

            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(key2Node.containsKey(key)) {
                Node node = key2Node.get(key);
                deleteNode(node);

                putToHead(node);

                return node.val;
            }

            return -1;
        }

        public void put(int key, int value) {
            Node node = null;
            if(key2Node.containsKey(key)) {
                node = key2Node.get(key);
                deleteNode(node);

                node.val = value;
                putToHead(node);
            }
            else {
                if(curSize >= capacity) {
                    key2Node.remove(tail.prev.key);
                    deleteNode(tail.prev);
                }

                node = new Node(key, value);
                key2Node.put(key, node);

                putToHead(node);
                curSize++;
            }
        }

        private void deleteNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        private void putToHead(Node node) {
            node.next = head.next;
            head.next.prev = node;

            head.next = node;
            node.prev = head;
        }
    }

    public static void main(String[] args) {
        LRUCache obj = new _146_LRU_Cache().new LRUCache(1);
        obj.put(2, 1);
        obj.get(2);
        obj.put(3, 2);
        obj.get(2);
        obj.get(3);
    }
}
