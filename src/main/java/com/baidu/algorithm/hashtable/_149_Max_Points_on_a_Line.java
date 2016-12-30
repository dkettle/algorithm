/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import com.baidu.algorithm.annotation.Note;

/**
 * _149_Max_Points_on_a_Line
 *
 * @author xuhaoran01
 */
public class _149_Max_Points_on_a_Line {

    @Note(desc = "map中Double key 区分0.0 和 -0.0, 第二层循环必须从j = 0开始")
    public int maxPoints(Point[] points) {

        if (points == null) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> mp = new HashMap<>();
            int dup = 0;

            for (int j = 0; j < points.length; j++) {

                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                } else if (points[j].x == points[i].x) {
                    mp.put(Double.MAX_VALUE, mp.getOrDefault(Double.MAX_VALUE, 0) + 1);
                } else {
                    double val = (double) (points[j].y - points[i].y) / (points[j].x - points[i].x);
                    mp.put(val, mp.getOrDefault(val, 0) + 1);
                }
            }

            res = Math.max(res, dup);
            for (Map.Entry<Double, Integer> entry : mp.entrySet()) {
                res = Math.max(res, entry.getValue() + dup);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Point[] points = {new Point(2, 3), new Point(3, 3), new Point(-5, 3)};
        new _149_Max_Points_on_a_Line().maxPoints(points);
    }
}
