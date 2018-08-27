/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _780_Reaching_Points
 *
 * @author xuhaoran01
 */
public class _780_Reaching_Points {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }

        return (sx == tx && (ty - sy) % sx == 0) || (sy == ty && (tx - sx) % sy == 0);
    }

    public static void main(String[] args) {
        new _780_Reaching_Points().reachingPoints(3, 3, 12, 9);
    }
}
