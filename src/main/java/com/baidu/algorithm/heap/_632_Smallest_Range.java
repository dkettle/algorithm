/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.heap;

import java.util.List;
import java.util.PriorityQueue;

/**
 * _632_Smallest_Range
 *
 * @author xuhaoran01
 */
public class _632_Smallest_Range {

    public int[] smallestRange(List<List<Integer>> nums) {
        int resX = 0, resY = Integer.MAX_VALUE, curMax = Integer.MIN_VALUE;
        int[] next = new int[nums.size()];

        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j]));
        for (int i = 0; i < nums.size(); i++) {
            curMax = Math.max(curMax, nums.get(i).get(0));
            pq.add(i);
        }

        while (!pq.isEmpty()) {
            int idx = pq.poll(), curMin = nums.get(idx).get(next[idx]);
            if (resY - resX > curMax - curMin) {
                resY = curMax;
                resX = curMin;
            }

            next[idx]++;
            if (next[idx] == nums.get(idx).size()) {
                break;
            }

            pq.add(idx);
            curMax = Math.max(curMax, nums.get(idx).get(next[idx]));
        }

        return new int[]{resX, resY};
    }
}
