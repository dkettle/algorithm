/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _769_Max_Chunks_To_Make_Sorted
 *
 * @author xuhaoran01
 */
public class _769_Max_Chunks_To_Make_Sorted {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length, res = 0, curMax = 0;
        for (int i = 0; i < n; i++) {
            curMax = Math.max(curMax, arr[i]);
            if (curMax == i) {
                res++;
            }
        }

        return res;
    }
}
