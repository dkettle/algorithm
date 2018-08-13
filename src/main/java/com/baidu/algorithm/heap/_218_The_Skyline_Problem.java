/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * _218_The_Skyline_Problem
 *
 * @author xuhaoran01
 */
public class _218_The_Skyline_Problem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return res;
        }

        Queue<int[]> line = new PriorityQueue<>((x, y) -> {
            if (x[0] != y[0]) {
                return x[0] - y[0];
            } else {
                return x[1] - y[1];
            }
        });
        for (int[] building : buildings) {
            line.add(new int[]{building[0], -building[2]}); // 1.distinguish start end 2.
            line.add(new int[]{building[1], building[2]});
        }

        Queue<Integer> height = new PriorityQueue<>((x, y) -> (y - x));
        height.add(0);

        int prev = 0;
        while (!line.isEmpty()) {
            int[] curLine = line.remove();
            if (curLine[1] < 0) {
                height.add(-curLine[1]);
            } else {
                height.remove(curLine[1]);
            }

            int cur = height.peek();
            if (prev != cur) {
                res.add(new int[]{curLine[0], cur});
                prev = cur;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[][] buildings = new int[][]{
                {0, 2, 3},
                {2, 5, 3}
        };
        new _218_The_Skyline_Problem().getSkyline(buildings);
    }
}
