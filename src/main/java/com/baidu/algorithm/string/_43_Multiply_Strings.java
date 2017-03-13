/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _43_Multiply_Strings
 *
 * @author xuhaoran01
 */
public class _43_Multiply_Strings {

    public String multiply(String num1, String num2) {

        int m = num1.length(), n = num2.length();
        int[] arr = new int[m + n];

        char[] cArr1 = num1.toCharArray();
        char[] cArr2 = num2.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i + j + 1] += (cArr1[i] - '0') * (cArr2[j] - '0');
            }
        }

        for (int i = m + n - 1; i > 0; i--) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }

        int i = 0;
        for (; i < m + n; i++) {
            if (arr[i] > 0) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (; i < m + n; i++) {
            sb.append(String.valueOf(arr[i]));
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
