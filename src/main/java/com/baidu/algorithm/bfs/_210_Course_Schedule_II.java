/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.*;

/**
 * _210_Course_Schedule_II
 *
 * @author xuhaoran01
 */
public class _210_Course_Schedule_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> outs = new HashMap<>();
        for (int[] pr : prerequisites) {
            int post = pr[0], pre = pr[1];
            inDegree[post]++;
            if (outs.containsKey(pre)) {
                outs.get(pre).add(post);
            } else {
                outs.put(pre, new ArrayList<>(Arrays.asList(post)));
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            res[idx++] = t;

            List<Integer> out = outs.getOrDefault(t, new ArrayList<>());
            for (int i = 0; i < out.size(); i++) {
                int next = out.get(i);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return idx == numCourses ? res : new int[0];
    }
}
