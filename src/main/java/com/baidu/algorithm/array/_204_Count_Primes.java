/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

import java.util.Arrays;

/**
 * _204_Count_Primes
 *
 * @author xuhaoran01
 */
public class _204_Count_Primes {

    public int countPrimes(int n) {

        if (n <= 2) {
            return 0;
        }

        boolean[] prime = new boolean[n];
        Arrays.fill(prime, 2, n, true);

        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        int res = 0;
        for (boolean b : prime) {
            res += b ? 1 : 0;
        }

        return res;
    }
}
