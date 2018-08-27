/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * _850_Rectangle_Area_II
 *
 * @author xuhaoran01
 */
public class _850_Rectangle_Area_II {

    public int rectangleArea(int[][] recs) {
        if (recs == null || recs.length == 0) {
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (x[0] - y[0]));
        for (int[] rec : recs) {
            pq.add(new int[]{rec[1], 0, rec[0], rec[2]});
            pq.add(new int[]{rec[3], 1, rec[0], rec[2]});
        }

        List<int[]> activeLines = new ArrayList<>();

        long res = 0;
        int prevY = pq.peek()[0];
        while (!pq.isEmpty()) {
            int[] line = pq.remove();
            int curY = line[0], op = line[1], x1 = line[2], x2 = line[3], curMax = -1;

            for (int[] active : activeLines) {
                curMax = Math.max(curMax, active[0]);
                res += (long) Math.max((active[1] - curMax), 0) * (curY - prevY);
                curMax = Math.max(curMax, active[1]);
            }

            if (op == 0) {
                activeLines.add(new int[]{x1, x2});
                Collections.sort(activeLines, (x, y) -> (x[0] - y[0]));
            } else {
                for (int i = 0; i < activeLines.size(); i++) {
                    if (activeLines.get(i)[0] == x1 && activeLines.get(i)[1] == x2) {
                        activeLines.remove(i);
                        break;
                    }
                }
            }

            prevY = curY;
        }

        return (int) (res % 1000000007);
    }

    public static void main(String[] args) {
        new _850_Rectangle_Area_II().rectangleArea(new int[][]{
                {0, 0, 1000000000, 1000000000}
        });
    }
}
