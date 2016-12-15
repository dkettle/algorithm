/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.Arrays;

/**
 * _274_HIndex
 *
 * @author xuhaoran01
 */
public class _274_HIndex {

    // time:nlog(n) sort
    public int hIndex1(int[] citations) {

        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);
        int len = citations.length;

        for (int i = 0; i < len; i++) {
            if (citations[i] >= len - i) {
                return len - i;
            }
        }

        return 0;
    }

    // bucket sort time:n space:n
    public int hIndex(int[] citations) {

        if (citations == null || citations.length == 0) {
            return 0;
        }

        int len = citations.length, sum = 0;
        // citations bucket
        int[] index = new int[len + 1];

        Arrays.stream(citations).forEach(x -> {
            if (x > len) {
                index[len]++;
            } else {
                index[x]++;
            }
        });

        for (int i = len; i >= 0; i--) {
            sum += index[i];

            if (sum >= i) {
                return i;
            }
        }

        return 0;
    }
}
