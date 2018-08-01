/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _66_Plus_One
 *
 * @author xuhaoran01
 */
public class _66_Plus_One {

    public int[] plusOne(int[] digits) {

        int n = digits.length, carry = 1, i = n - 1;
        while (i >= 0 && carry > 0) {
            int temp = digits[i] + carry;
            carry = temp / 10;
            digits[i] = temp % 10;
            i--;
        }

        if (carry > 0) {
            int[] arr = new int[n + 1];
            arr[0] = carry;
            for(i = 1; i <= n; i++) {
                arr[i] = digits[i - 1];
            }

            digits = arr;
        }

        return digits;
    }
}
