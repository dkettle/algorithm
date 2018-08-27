/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _537_Complex_Number_Multiplication
 *
 * @author xuhaoran01
 */
public class _537_Complex_Number_Multiplication {
    private int[] transform(String s) {
        String[] field = s.split("\\+");
        return new int[]{Integer.valueOf(field[0]), Integer.valueOf(field[1].substring(0, field[1].length() - 1))};
    }

    public String complexNumberMultiply(String a, String b) {
        int[] ta = transform(a);
        int[] tb = transform(b);

        int l = ta[0] * tb[0] - ta[1] * tb[1];
        int r = ta[0] * tb[1] + ta[1] * tb[0];

        return new StringBuilder().append(l).append('+').append(r).append('i').toString();
    }
}
