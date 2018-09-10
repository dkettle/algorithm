/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

/**
 * _306_Additive_Number
 *
 * @author xuhaoran01
 */
public class _306_Additive_Number {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (isValid(num, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(String num, int i, int j) {
        if (i > 1 && num.charAt(0) == '0') {
            return false;
        }

        if (j > 1 && num.charAt(i) == '0') {
            return false;
        }

        Long first = Long.parseLong(num.substring(0, i));
        Long second = Long.parseLong(num.substring(i, i + j));
        String sum = null;
        for (int k = i + j; k < num.length(); k += sum.length()) {
            second += first;
            first = second - first;
            sum = second.toString();

            if (!num.startsWith(sum, k)) {
                return false;
            }
        }

        return true;
    }
}
