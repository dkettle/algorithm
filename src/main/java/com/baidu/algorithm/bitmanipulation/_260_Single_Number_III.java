/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bitmanipulation;

/**
 * _260_Single_Number_III
 *
 * @author xuhaoran01
 */
public class _260_Single_Number_III {
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length < 2) {
            return new int[0];
        }

        int xorRes = 0;
        for(int num: nums) {
            xorRes ^= num;
        }

        if(xorRes == 0) {
            return new int[0];
        }

        int shift = 1;
        while((shift & xorRes) == 0) {
            shift <<= 1;
        }

        int first = 0, second = 0;
        for(int num: nums) {
            if((num & shift) == 0) {
                first ^= num;
            }
            else {
                second ^= num;
            }
        }

        return new int[]{first, second};
    }

}
