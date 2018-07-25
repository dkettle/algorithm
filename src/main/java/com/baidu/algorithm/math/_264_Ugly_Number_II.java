/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * _264_Ugly_Number_II
 *
 * @author xuhaoran01
 */
public class _264_Ugly_Number_II {

    public int nthUglyNumber(int n) {

        if (n < 1) {
            return 0;
        }

        int idx2 = 0, idx3 = 0, idx5 = 0;
        List<Integer> nums = new ArrayList<>();
        nums.add(1);

        while (n > 1) {
            int num2 = 2 * nums.get(idx2);
            int num3 = 3 * nums.get(idx3);
            int num5 = 5 * nums.get(idx5);

            int minVal = Math.min(Math.min(num2, num3), num5);
            nums.add(minVal);

            if (minVal == num2) {
                idx2++;
            }

            if (minVal == num3) {
                idx3++;
            }

            if (minVal == num5) {
                idx5++;
            }

            n--;
        }

        return nums.get(nums.size() - 1);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++)
            System.out.println(new _264_Ugly_Number_II().nthUglyNumber(i));
    }
}
