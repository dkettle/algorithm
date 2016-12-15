/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

import java.util.Arrays;

/**
 * _136_Single_Number
 *
 * @author xuhaoran01
 */
public class _136_Single_Number {

    public int singleNumber(int[] nums) {

        int res = 0;
        for (int v : nums) {
            res ^= v;
        }

        return res;
    }
}
