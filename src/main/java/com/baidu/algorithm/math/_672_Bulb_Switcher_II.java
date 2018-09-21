/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _672_Bulb_Switcher_II
 *
 * @author xuhaoran01
 */
public class _672_Bulb_Switcher_II {
    /**
     * The first 6 lights uniquely determine the rest of the lights.
     * This is because every operation that modifies the x-th light also modifies the (x+6)-th light,
     * so the x-th light is always equal to the (x+6)-th light.
     * Actually, the first 3 lights uniquely determine the rest of the sequence,
     * as shown by the table below for performing the operations a, b, c, d:
     * Light 1 = 1 + a + c + d
     * Light 2 = 1 + a + b
     * Light 3 = 1 + a + c
     * Light 4 = 1 + a + b + d
     * Light 5 = 1 + a + c
     * Light 6 = 1 + a + b
     * So that (modulo 2):
     * Light 4 = (Light 1) + (Light 2) + (Light 3)
     * Light 5 = Light 3
     * Light 6 = Light 2
     * The above justifies taking n = min(n, 3) without loss of generality. The rest is now casework.
     * Let's denote the state of lights by the tuple (a, b, c).
     * The transitions are to XOR by (1, 1, 1), (0, 1, 0), (1, 0, 1), or (1, 0, 0).
     */
    public int flipLights(int n, int m) {
        if (n <= 0 || m < 0) {
            return 0;
        } else if (m == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else if (n == 2) {
            return m == 1 ? 3 : 4;
        } else {
            return m == 1 ? 4 : m == 2 ? 7 : 8;
        }
    }
}
