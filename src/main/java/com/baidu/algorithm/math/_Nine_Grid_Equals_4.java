/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.baidu.algorithm.annotation.Classic;

/**
 * _Nine_Grid_Equals_4
 *
 * @author xuhaoran01
 */
@Classic
public class _Nine_Grid_Equals_4 {

    /**
     *      a + b - 9 = 4
     *      +   -   -
     *      c - d * e = 4
     *      /   *   -
     *      f + g - h = 4
     *      =   =   =
     *      4   4   4
     * 可填数字为0-100之间，通过程序求出ABCDEFGH所有解。​
     *
     * a + b = 13 => b <= 13
     * b - d * g = 4 => b >= 4, 1 <= d <= 9
     * 9 - e - h = 4 => e <= 5
     */

    // 只要确认了B、D、E，其余A、C、F、G、H就可以通过运算算出来
    public List<List<Integer>> solveNineGrid() {

        List<List<Integer>> res = new ArrayList<>();

        for (int b = 9; b <= 13; b++) {
            for (int d = 1; d <= 9; d++) {
                for (int e = 0; e <= 5; e++) {

                    if ((b - 4) % d != 0) {
                        continue;
                    }

                    int a = 13 - b;
                    int c = 4 + d * e;
                    int h = 5 - e;
                    int g = (b - 4) / d;
                    int f = 4 + h - g;

                    if (f > 0 && (4 - a) * f == c) {
                        res.add(Arrays.asList(a, b, c, d, e, f, g, h));
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new _Nine_Grid_Equals_4().solveNineGrid();
        System.out.println(System.nanoTime() - start);
    }
}
