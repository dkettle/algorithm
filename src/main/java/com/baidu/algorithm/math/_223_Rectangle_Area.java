/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

import com.baidu.algorithm.annotation.Note;

/**
 * _223_Rectangle_Area
 *
 * @author xuhaoran01
 */
public class _223_Rectangle_Area {

    @Note(desc = "first minus the add to avoid overflow")
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaOfSqrA = (C-A) * (D-B);
        int areaOfSqrB = (G-E) * (H-F);

        int left = Math.max(A, E);
        int right = Math.max(Math.min(G, C), left);
        int bottom = Math.max(F, B);
        int top = Math.max(Math.min(D, H), bottom);

        return areaOfSqrA - (right - left) * (top - bottom) + areaOfSqrB;
    }

    public static void main(String[] args) {

        int a = -1500000001;
        int b = 0;
        int c = -1500000000;
        int d = 1;
        int e = 1500000000;
        int f = 0;
        int g = 1500000001;
        int h = 1;

        new _223_Rectangle_Area().computeArea(a, b, c, d, e, f, g, h);
    }
}
