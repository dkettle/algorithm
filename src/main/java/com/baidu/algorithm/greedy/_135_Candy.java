/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.greedy;

/**
 * _135_Candy
 *
 * @author xuhaoran01
 */
public class _135_Candy {

    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length, res = n;
        int[] candy = new int[n];
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        for(int v: candy) {
            res += v;
        }

        return res;
    }
}
