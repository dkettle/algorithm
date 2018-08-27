/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * _630_Course_Schedule_III
 *
 * @author xuhaoran01
 */
public class _630_Course_Schedule_III {
    public int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length == 0) {
            return 0;
        }

        Arrays.sort(courses, (x, y) -> x[1] - y[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        int time = 0;

        for (int[] course : courses) {
            if (time + course[0] <= course[1]) {
                time += course[0];
                pq.add(course[0]);
            } else if (!pq.isEmpty() && pq.peek() > course[0]) {
                time += course[0] - pq.peek();
                pq.remove();
                pq.add(course[0]);
            }
        }

        return pq.size();
    }

    public static void main(String[] args) {
        new _630_Course_Schedule_III().scheduleCourse(new int[][]{
                {5, 5},
                {4, 6},
                {2, 6},
        });
    }
}
