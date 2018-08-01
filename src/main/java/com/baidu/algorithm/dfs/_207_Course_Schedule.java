/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dfs;

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

        Map<Integer, List<Integer>> postReq = new HashMap<>();
        for (int[] arr : prerequisites) {
            if (postReq.containsKey(arr[1])) {
                postReq.get(arr[1]).add(arr[0]);
            } else {
                postReq.put(arr[1], new ArrayList<>(Arrays.asList(arr[0])));
            }
        }

        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!dfs(visited, i, postReq)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(boolean[] visited, int idx, Map<Integer, List<Integer>> postReq) {

        visited[idx] = true;
        List<Integer> posts = postReq.get(idx);
        if (posts != null) {
            for (int p : posts) {
                if (visited[p] || !dfs(visited, p, postReq)) {
                    return false;
                }
            }
        }
        visited[idx] = false;

        return true;
    }

    public static void main(String[] args) {
        new _207_Course_Schedule().canFinish(2, new int[][]{{0, 1}});
    }
}
