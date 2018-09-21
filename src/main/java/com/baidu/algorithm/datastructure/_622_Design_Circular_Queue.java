/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

/**
 * _622_Design_Circular_Queue
 *
 * @author xuhaoran01
 */
public class _622_Design_Circular_Queue {
    class MyCircularQueue {

        private int[] vals;
        private int k, sz;
        private int front, tail;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            vals = new int[k];
            this.k = k;
            sz = 0;

            front = 0;
            tail = 0;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            vals[front] = value;
            front = (front + 1) % k;
            sz++;

            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            tail = (tail + 1) % k;
            sz--;

            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty()) {
                return -1;
            }

            return vals[tail];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }

            return vals[(front - 1 + k) % k];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return sz == 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return sz == k;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new _622_Design_Circular_Queue().new MyCircularQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        queue.Rear();
        queue.isFull();
        queue.deQueue();
        queue.enQueue(4);
        queue.Rear();
    }
}
