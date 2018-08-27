/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * _786_Kth_Smallest_Prime_Fraction
 *
 * @author xuhaoran01
 */
public class _786_Kth_Smallest_Prime_Fraction {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        if (A == null || A.length == 0 || K < 1) {
            return new int[0];
        }

        Queue<int[]> pq = new PriorityQueue<>((x, y) -> A[x[0]] * A[y[1]] - A[x[1]] * A[y[0]]);
        int N = A.length;
        for (int i = 0; i < N - 1 && i < K; i++) {
            pq.add(new int[]{i, N - 1});
        }

        for (int i = 0; i < K - 1; i++) {
            int[] cur = pq.remove();
            if (cur[1] > cur[0] + 1) {
                pq.add(new int[]{cur[0], cur[1] - 1});
            }
        }

        return new int[]{A[pq.peek()[0]], A[pq.peek()[1]]};
    }
}
