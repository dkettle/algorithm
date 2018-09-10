/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _667_Beautiful_Arrangement_II
 *
 * @author xuhaoran01
 */
public class _667_Beautiful_Arrangement_II {

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];

        for (int i = 1; i < n - k; i++) {
            res[i - 1] = i;
        }

        for (int i = 0; i <= k; i++) {
            res[n - k - 1 + i] = (i % 2 == 0) ? (n - k + i / 2) : (n - i / 2);
        }

        return res;
    }
}
