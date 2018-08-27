/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

import java.util.HashSet;
import java.util.Set;

/**
 * _391_Perfect_Rectangle
 *
 * @author xuhaoran01
 */
public class _391_Perfect_Rectangle {
    public boolean isRectangleCover(int[][] rectangles) {

        if (rectangles == null || rectangles.length == 0) {
            return true;
        }

        int xMin = Integer.MAX_VALUE, yMin = xMin;
        int xMax = Integer.MIN_VALUE, yMax = xMax;
        int smallArea = 0;
        Set<String> set = new HashSet<>();

        for (int[] rec : rectangles) {
            smallArea += (rec[2] - rec[0]) * (rec[3] - rec[1]);

            xMin = Math.min(xMin, rec[0]);
            yMin = Math.min(yMin, rec[1]);
            xMax = Math.max(xMax, rec[2]);
            yMax = Math.max(yMax, rec[3]);

            String[] pArr = new String[]{
                    rec[0] + " " + rec[1],
                    rec[0] + " " + rec[3],
                    rec[2] + " " + rec[1],
                    rec[2] + " " + rec[3]
            };

            for (String p : pArr) {
                if (set.contains(p)) {
                    set.remove(p);
                } else {
                    set.add(p);
                }
            }
        }

        return (yMax - yMin) * (xMax - xMin) == smallArea
                && set.size() == 4
                && set.contains(xMin + " " + yMin)
                && set.contains(xMin + " " + yMax)
                && set.contains(xMax + " " + yMin)
                && set.contains(xMax + " " + yMax);
    }

}
