/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * _120_Triangle
 *
 * @author xuhaoran01
 */
public class _120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty()) {
            return 0;
        }

        List<Integer> minPath = new ArrayList<>(triangle.get(0));
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> cur = triangle.get(i);
            minPath.add(cur.get(i) + minPath.get(i - 1));
            for(int j = minPath.size() - 2; j > 0; j--) {
                minPath.set(j, cur.get(j) + Math.min(minPath.get(j), minPath.get(j - 1)));
            }
            minPath.set(0, cur.get(0) + minPath.get(0));
        }

        int res = Integer.MAX_VALUE;
        for(int v: minPath) {
            res = Math.min(res, v);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
