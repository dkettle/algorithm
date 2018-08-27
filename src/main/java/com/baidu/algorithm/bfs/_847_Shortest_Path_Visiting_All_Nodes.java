/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * _847_Shortest_Path_Visiting_All_Nodes
 *
 * @author xuhaoran01
 */
public class _847_Shortest_Path_Visiting_All_Nodes {
    class State {
        public int cover, head;

        public State(int c, int h) {
            cover = c;
            head = h;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<State> queue = new LinkedList<>();
        int[][] dist = new int[1 << n][n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            queue.add(new State(1 << i, i));
            dist[1 << i][i] = 0;
        }

        while (!queue.isEmpty()) {
            State cur = queue.remove();
            int d = dist[cur.cover][cur.head];
            if (cur.cover == (1 << n) - 1) {
                return d;
            }

            for (int child : graph[cur.head]) {
                int childCover = cur.cover | (1 << child);
                if (d + 1 < dist[childCover][child]) {
                    dist[childCover][child] = d + 1;
                    queue.add(new State(childCover, child));
                }
            }
        }

        return -1;
    }
}
