/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * _60_Permutation_Sequence
 *
 * @author xuhaoran01
 */
public class _60_Permutation_Sequence {

//    private int factor(int n) {
//
//        int res = 1;
//        for (int i = 1; i <= n; i++) {
//            res *= i;
//        }
//
//        return res;
//    }
//
//    public String getPermutation(int n, int k) {
//
//        List<Integer> nums = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            nums.add(i + 1);
//        }
//
//        String res = "";
//        k--;
//
//        while (n > 0) {
//            int factor = factor(--n);
//            res += String.valueOf(nums.get(k / factor));
//            nums.remove(k / factor);
//            k %= factor;
//        }
//
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(new _60_Permutation_Sequence().getPermutation(3, 3));
    }

    private int calc_factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }

        return res;
    }

    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        String res = "";
        k--;
        while (n > 0) {
            int fact = calc_factorial(n - 1);
            n--;

            res += String.valueOf(nums.get(k / fact));
            nums.remove(k / fact);

            k %= fact;
        }

        return res;
    }
}
