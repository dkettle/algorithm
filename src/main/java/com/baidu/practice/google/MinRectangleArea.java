/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.google;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * MinRectangleArea
 *
 * @author xuhaoran01
 */


public class MinRectangleArea {

    public int minArea(Point[] points) {
        if (points == null || points.length < 4) {
            return 0;
        }

        Set<Point> set = new HashSet<>();
        for (Point pt : points) {
            set.add(pt);
        }

        int n = points.length, res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Point p1 = points[i];
            for (int j = i + 1; j < n; j++) {
                Point p2 = points[j];
                if (p1.x == p2.x || p1.y == p2.y) {
                    continue;
                }

                if (set.contains(new Point(p1.x, p2.y)) && set.contains(new Point(p2.x, p1.y))) {
                    res = Math.min(res, Math.abs((p1.x - p2.x) * (p1.y - p2.y)));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinRectangleArea().minArea(new Point[]{
                new Point(1, 0),
                new Point(0, 1),
                new Point(1, 1),
                new Point(0, 0),
                new Point(2, 0),
        }));;
    }
}
