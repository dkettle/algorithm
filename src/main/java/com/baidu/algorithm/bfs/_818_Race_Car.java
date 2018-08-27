/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * _818_Race_Car
 *
 * @author xuhaoran01
 */
public class _818_Race_Car {

    class State {
        public int position, speed;

        public State(int p, int s) {
            position = p;
            speed = s;
        }

        public String toString() {
            return position + "/" + speed;
        }
    }

    public int racecar(int target) {

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 1));

        Set<String> visited = new HashSet<>();

        int res = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                State s = queue.remove();
                String cur = s.toString();

                if (visited.contains(cur) || Math.abs(s.position - target) > target) {
                    continue;
                }

                visited.add(cur);
                if (s.position == target) {
                    return res;
                }

                queue.add(new State(s.position + s.speed, s.speed * 2));
                queue.add(new State(s.position, s.speed > 0 ? -1 : 1));
            }

            res++;
        }

        return -1;
    }
}
