/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.awt.Point;
import java.util.*;

/**
 * _347_Top_K_Frequent_Elements
 *
 * @author xuhaoran01
 */
public class _347_Top_K_Frequent_Elements {
    public List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Point> pq = new PriorityQueue<>((x, y) -> x.y - y.y);
        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            if (pq.size() < k) {
                pq.add(new Point(num, freq));
            } else if (pq.peek().y < freq) {
                pq.remove();
                pq.add(new Point(num, freq));
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.remove().x);
        }

        return res;
    }

    public static void main(String[] args) {
        new _347_Top_K_Frequent_Elements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;
        List<Integer>[] bucket = new List[n + 1];
        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        for (int i = n; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    if (res.size() < k) {
                        res.add(num);
                    }
                }
            }
        }

        return res;
    }
}
