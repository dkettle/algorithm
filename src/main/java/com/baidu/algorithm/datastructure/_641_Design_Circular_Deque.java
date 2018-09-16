/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

/**
 * _641_Design_Circular_Deque
 *
 * @author xuhaoran01
 */
public class _641_Design_Circular_Deque {

    class MyCircularDeque {

        private int[] vals;
        private int k, sz;
        private int front, tail;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            vals = new int[k];

            this.k = k;
            sz = 0;

            front = 0;
            tail = k - 1;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (sz == k) {
                return false;
            }

            vals[front] = value;
            sz++;

            front = (front + 1) % k;

            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (sz == k) {
                return false;
            }

            vals[tail] = value;
            sz++;

            tail = (tail - 1 + k) % k;

            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (sz == 0) {
                return false;
            }

            front = (front - 1 + k) % k;
            sz--;

            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (sz == 0) {
                return false;
            }

            tail = (tail + 1) % k;
            sz--;

            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (sz == 0) {
                return -1;
            }

            return vals[(front - 1 + k) % k];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (sz == 0) {
                return -1;
            }

            return vals[(tail + 1) % k];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return sz == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return sz == k;
        }
    }
}
