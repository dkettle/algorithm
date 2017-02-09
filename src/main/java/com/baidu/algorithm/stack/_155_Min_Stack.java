/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.util.Stack;

/**
 * _155_Min_Stack
 *
 * @author xuhaoran01
 */
public class _155_Min_Stack {

    public static void main(String[] args) {

        MinStack minStack = new _155_Min_Stack().new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);

        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    public class MinStack {

        private Stack<Integer> numStack;

        private Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

            numStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {

            numStack.push(x);
            if (minStack.isEmpty() || (x <= minStack.peek())) {
                minStack.push(x);
            }
        }

        public void pop() {

            int top = numStack.pop();
            if (top == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {

            return numStack.peek();
        }

        public int getMin() {

            return minStack.peek();
        }
    }
}
