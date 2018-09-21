/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

import java.util.Random;

/**
 * _384_Shuffle_an_Array
 *
 * @author xuhaoran01
 */
public class _384_Shuffle_an_Array {

    class Solution {

        private int[] origin;
        private int[] array;

        public Solution(int[] nums) {
            origin = nums;
            array = origin.clone();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            array = origin;
            origin = array.clone();

            return array;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            Random r = new Random();
            for (int i = array.length - 1; i > 0; i--) {
                int j = r.nextInt(i + 1);
                swap(array, i, j);
            }

            return array;
        }

        private void swap(int[] num, int i, int j) {
            int t = num[i];
            num[i] = num[j];
            num[j] = t;
        }
    }
}
