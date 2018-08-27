/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * _699_Falling_Squares
 *
 * @author xuhaoran01
 */
public class _699_Falling_Squares {
    class Interval {
        public int l, r, h;

        public Interval(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions.length == 0) {
            return res;
        }

        List<Interval> intervals = new ArrayList<>();
        int h = 0;
        for (int[] pos : positions) {
            h = Math.max(h, getHeight(intervals, new Interval(pos[0], pos[0] + pos[1] - 1, pos[1])));
            res.add(h);
        }

        return res;
    }

    private int getHeight(List<Interval> intervals, Interval cur) {
        int h = 0;
        for (Interval interval : intervals) {
            if (interval.l > cur.r || interval.r < cur.l) {
                continue;
            }

            h = Math.max(h, interval.h);
        }

        cur.h += h;
        intervals.add(cur);

        return cur.h;
    }

    public static void main(String[] args) {
        new _699_Falling_Squares().fallingSquares(new int[][]{
                {9, 7},
                {1, 9},
                {3, 1}
        });
    }
}
