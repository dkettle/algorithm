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

    private int getGcd(int x, int y) {
        if (x > y) {
            return getGcd(y, x);
        } else if (x == 0) {
            return y;
        } else {
            return getGcd(y % x, x);
        }
    }

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        int res = 0;
        for (Point p1 : points) {
            Map<String, Integer> map = new HashMap<>();
            int dup = 0;
            for (Point p2 : points) {
                if (p1.x == p2.x && p1.y == p2.y) {
                    dup++;
                } else if (p1.x == p2.x) {
                    map.put("infinite", map.getOrDefault("infinite", 0) + 1);
                } else {
                    int xDiff = Math.abs(p2.x - p1.x);
                    int yDiff = Math.abs(p2.y - p1.y);
                    int gcd = getGcd(xDiff, yDiff);
                    String sign = (((p2.x - p1.x) ^ (p2.y - p1.y)) & (1 << 31)) != 0 ? "-" : "+";

                    xDiff /= gcd;
                    yDiff /= gcd;

                    String key = sign + String.valueOf(xDiff) + "-" + String.valueOf(yDiff);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }

            res = Math.max(res, dup);
            for (int times : map.values()) {
                res = Math.max(res, dup + times);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Point[] points = {new Point(1, 1), new Point(2, 2), new Point(-3, 3)};
        new _149_Max_Points_on_a_Line().maxPoints(points);
    }
}
