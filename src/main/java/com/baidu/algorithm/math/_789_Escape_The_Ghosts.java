/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _789_Escape_The_Ghosts
 *
 * @author xuhaoran01
 */
public class _789_Escape_The_Ghosts {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int step = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            if (Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= step) {
                return false;
            }
        }

        return true;
    }
}
