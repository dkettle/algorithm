/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _768_Max_Chunks_To_Make_Sorted_II
 *
 * @author xuhaoran01
 */
public class _768_Max_Chunks_To_Make_Sorted_II {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length, res = 0;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];

        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
        }

        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(arr[i], rightMin[i + 1]);
        }

        for (int i = 0; i < n - 1; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                res++;
            }
        }

        return res + 1;
    }
}
