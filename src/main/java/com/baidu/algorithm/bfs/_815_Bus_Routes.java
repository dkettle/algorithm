/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.*;

/**
 * _815_Bus_Routes
 *
 * @author xuhaoran01
 */
public class _815_Bus_Routes {
    class Point {
        public int bus, depth;

        public Point(int b, int d) {
            bus = b;
            depth = d;
        }
    }

    private boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                return true;
            } else if (A[i] > B[j]) {
                j++;
            } else {
                i++;
            }
        }

        return false;
    }

    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0) {
            return -1;
        } else if (S == T) {
            return 0;
        }

        int N = routes.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Arrays.sort(routes[i]);
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> target = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (Arrays.binarySearch(routes[i], S) >= 0) {
                visited.add(i);
                queue.add(new Point(i, 0));
            }

            if (Arrays.binarySearch(routes[i], T) >= 0) {
                target.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            if (target.contains(cur.bus)) {
                return cur.depth + 1;
            }

            for (int next : graph.get(cur.bus)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(new Point(next, cur.depth + 1));
                }
            }
        }

        return -1;
    }
}
