/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

import java.util.Arrays;

/**
 * _238_Product_of_Array_Except_Self
 *
 * @author xuhaoran01
 */
public class _238_Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int rightProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rightProd;
            rightProd *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        new _238_Product_of_Array_Except_Self().productExceptSelf(new int[]{0, 4, 0});
    }
}
