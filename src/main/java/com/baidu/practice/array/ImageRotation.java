/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * ImageRotation
 *
 * @author xuhaoran01
 */
public class ImageRotation {

    public void reverse_arr(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public void rotate(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length != nums.length) {
            return;
        }

        int n = nums[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            reverse_arr(nums[i]);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = 5;
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = rand.nextInt(100);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }

        System.out.println();

        ImageRotation ir = new ImageRotation();
        ir.rotate(nums);

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}
