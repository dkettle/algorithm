/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.greedy;

import java.util.PriorityQueue;

/**
 * _502_IPO
 *
 * @author xuhaoran01
 */
public class _502_IPO {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pqCapital = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        PriorityQueue<Integer> pqProfit = new PriorityQueue<>((x, y) -> y - x);

        for (int i = 0; i < Capital.length; i++) {
            pqCapital.add(new int[]{Capital[i], Profits[i]});
        }

        while (k > 0) {
            while (!pqCapital.isEmpty() && pqCapital.peek()[0] <= W) {
                pqProfit.add(pqCapital.remove()[1]);
            }

            if (pqProfit.isEmpty()) {
                break;
            }

            W += pqProfit.remove();
            k--;
        }

        return W;
    }
}
