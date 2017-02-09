/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bitmanipulation;

import java.util.Arrays;

/**
 * _477_Total_Hamming_Distance
 *
 * @author xuhaoran01
 */
public class _477_Total_Hamming_Distance {


    public int totalHammingDistance(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int len = nums.length;
        int[] count = new int[32];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) > 0) {
                    count[j]++;
                }
            }
        }

        int res = 0;
        for (int v : count) {
            res += v * (len - v);
        }

        return res;
    }

    public static void main(String[] args) {

        new _477_Total_Hamming_Distance().totalHammingDistance(new int[]{4, 14, 2});
    }
}
