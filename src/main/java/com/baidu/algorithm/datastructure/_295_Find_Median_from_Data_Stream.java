/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

import java.util.PriorityQueue;

/**
 * _295_Find_Median_from_Data_Stream
 *
 * @author xuhaoran01
 */
public class _295_Find_Median_from_Data_Stream {
    class MedianFinder {

        private PriorityQueue<Integer> left, right;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            left = new PriorityQueue<>((x, y) -> (y - x)); // maxHeap
            right = new PriorityQueue<>((x, y) -> (x - y)); // minHeap
        }

        public void addNum(int num) {
            left.add(num);

            right.add(left.remove());
            while (left.size() < right.size()) {
                left.add(right.remove());
            }
        }

        public double findMedian() {
            if (left.isEmpty()) {
                return 0;
            } else if (left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return left.peek();
            }
        }
    }
}
