/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * _447_Number_of_Boomerangs
 *
 * @author xuhaoran01
 */
public class _447_Number_of_Boomerangs {

    public int numberOfBoomerangs(int[][] points) {

        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }

        int numOfPoints = points.length;
        int[][] dist = new int[numOfPoints][numOfPoints];

        for (int i = 0; i < numOfPoints; i++) {
            for (int j = i + 1; j < numOfPoints; j++) {
                int xDist = points[i][0] - points[j][0];
                int yDist = points[i][1] - points[j][1];
                dist[i][j] = dist[j][i] = xDist * xDist + yDist * yDist;
            }
        }

        int res = 0;
        for (int i = 0; i < numOfPoints; i++) {
            Map<Integer, Integer> mp = new HashMap<>();
            for (int j = 0; j < numOfPoints; j++) {
                int v = dist[i][j];
                mp.put(v, mp.get(v) == null ? 1 : mp.get(v) + 1);
            }

            for (int v : mp.values()) {
                res += v * (v - 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(new _447_Number_of_Boomerangs().numberOfBoomerangs(points));
    }
}
