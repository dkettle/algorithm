/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _858_Mirror_Reflection
 *
 * @author xuhaoran01
 */
public class _858_Mirror_Reflection {
    private double EPS = 1e-6;

    private boolean isClose(double x, double y) {
        return Math.abs(x - y) < EPS;
    }

    // 模拟
    public int mirrorReflection1(int p, int q) {
        double x = 0, y = 0, dx = p, dy = q;

        while (!(isClose(x, p) && isClose(y, 0)) && !(isClose(x, p) && isClose(y, p)) && !(isClose(x, 0) && isClose(y, p))) {
            double t = 1e9;

            // x + dx * t = 0|p
            if (-x / dx > EPS) {
                t = Math.min(t, -x / dx);
            }

            if ((p - x) / dx > EPS) {
                t = Math.min(t, (p - x) / dx);
            }

            if (-y / dy > EPS) {
                t = Math.min(t, -y / dy);
            }

            if ((p - y) / dy > EPS) {
                t = Math.min(t, (p - y) / dy);
            }

            x += dx * t;
            y += dy * t;

            if (isClose(x, p) || isClose(x, 0)) {
                dx *= -1;
            }

            if (isClose(y, p) || isClose(y, 0)) {
                dy *= -1;
            }
        }

        if (isClose(x, p) && isClose(y, 0)) {
            return 0;
        } else if (isClose(x, p) && isClose(y, p)) {
            return 1;
        } else {
            return 2;
        }
    }

    // 光线在水平方向走p,在垂直方向必定走q. 找最小公倍数。
    public int mirrorReflection(int p, int q) {
        int vertDist = 0;
        for (int i = 1; ; i++) {
            vertDist += q;
            vertDist %= 2 * p;

            if (vertDist == 0) {
                return 0;
            } else if (vertDist == p) {
                return i % 2 == 1 ? 1 : 2;
            }
        }
    }

    public static void main(String[] args) {
        new _858_Mirror_Reflection().mirrorReflection(2, 1);
    }
}
