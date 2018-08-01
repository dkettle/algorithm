/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.*;

/**
 * _207_Course_Schedule
 *
 * @author xuhaoran01
 */
public class _207_Course_Schedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 2) {
            return true;
        }

        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> outs = new HashMap<>();
        for (int[] pr : prerequisites) {
            inDegree[pr[0]]++;
            if (outs.containsKey(pr[1])) {
                outs.get(pr[1]).add(pr[0]);
            } else {
                outs.put(pr[1], new ArrayList<>(Arrays.asList(pr[0])));
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int outCnt = 0;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            outCnt++;

            List<Integer> out = outs.getOrDefault(t, new ArrayList<>());
            for (int i = 0; i < out.size(); i++) {
                inDegree[out.get(i)]--;
                if (inDegree[out.get(i)] == 0) {
                    queue.add(out.get(i));
                }
            }
        }

        return outCnt == numCourses;
    }

    public static void main(String[] args) {
        new _207_Course_Schedule().canFinish(3, new int[][]{{1, 0}, {2, 1}});
    }
}
