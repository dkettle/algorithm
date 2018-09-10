/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * _841_Keys_and_Rooms
 *
 * @author xuhaoran01
 */
public class _841_Keys_and_Rooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.isEmpty()) {
            return true;
        }

        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;

        Queue<Integer> queue = new LinkedList<>();
        for (int r : rooms.get(0)) {
            queue.add(r);
        }

        while (!queue.isEmpty()) {
            int r = queue.remove();
            if (!visited[r]) {
                visited[r] = true;
                for (int nr : rooms.get(r)) {
                    queue.add(nr);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}
