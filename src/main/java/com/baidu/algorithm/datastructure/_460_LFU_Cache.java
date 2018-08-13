/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * _460_LFU_Cache
 *
 * @author xuhaoran01
 */
public class _460_LFU_Cache {

    class LFUCache {

        class Node {
            public int key, val, cnt;
            public Node prev, next;

            public Node(int k, int v) {
                key = k;
                val = v;
                cnt = 1;
            }
        }

        class DoubleLinkedList {
            Node head, tail;

            public DoubleLinkedList() {
                head = new Node(0, 0);
                tail = new Node(0, 0);

                head.next = tail;
                tail.prev = head;
            }

            public void addFirst(Node node) {
                node.next = head.next;
                node.next.prev = node;

                node.prev = head;
                head.next = node;
            }

            public Node remove(Node node) {
                node.next.prev = node.prev;
                node.prev.next = node.next;

                return node;
            }

            public Node removeLast() {
                if (!isEmpty()) {
                    return remove(tail.prev);
                } else {
                    return null;
                }
            }

            public boolean isEmpty() {
                return head.next == tail;
            }
        }

        private Map<Integer, Node> nodeMap;
        private Map<Integer, DoubleLinkedList> countMap;
        private int cap, sz, minCount;

        public LFUCache(int capacity) {
            nodeMap = new HashMap<>();
            countMap = new HashMap<>();

            cap = capacity;
            sz = 0;
            minCount = 0;
        }

        public int get(int key) {
            if (nodeMap.containsKey(key)) {
                Node node = nodeMap.get(key);
                update(node);

                return node.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (cap == 0) {
                return;
            }

            if (nodeMap.containsKey(key)) {
                Node node = nodeMap.get(key);
                node.val = value;

                update(node);
            } else {
                Node node = new Node(key, value);
                if (sz >= cap) {
                    Node t = countMap.get(minCount).removeLast();
                    if (t != null) {
                        nodeMap.remove(t.key);
                    }
                }

                sz++;
                minCount = 1;

                nodeMap.put(key, node);
                DoubleLinkedList countList = countMap.getOrDefault(node.cnt, new DoubleLinkedList());
                countList.addFirst(node);
                countMap.put(node.cnt, countList);
            }
        }

        private void update(Node node) {
            DoubleLinkedList dl = countMap.get(node.cnt);
            dl.remove(node);

            if (dl.isEmpty() && node.cnt == minCount) {
                minCount++;
            }

            node.cnt++;
            DoubleLinkedList countList = countMap.getOrDefault(node.cnt, new DoubleLinkedList());
            countList.addFirst(node);
            countMap.put(node.cnt, countList);
        }
    }

    public static void main(String[] args) {

        LFUCache obj = new _460_LFU_Cache().new LFUCache(2);
    }

}
