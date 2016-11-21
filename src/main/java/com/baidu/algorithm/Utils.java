/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm;

import java.util.List;
import java.util.Random;

/**
 * Utils
 *
 * @author xuhaoran01
 */
public class Utils {

    // Collections.swap
    //
    public static void swap(List<Integer> list, int i, int j) throws IndexOutOfBoundsException {

        if (list == null || list.isEmpty() || i == j) {
            return;
        }

        if (i >= list.size() || j >= list.size()) {
            throw new IndexOutOfBoundsException("swap index out of list size");
        }

        int tmp = list.get(i);

        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    // Collections.shuffle
    //
    public static void shuffle(List<Integer> nums) {

        if (nums == null || nums.size() == 0) {
            return;
        }

        Random rand = new Random();

        for (int i = nums.size(); i > 1; i--) {
            int index = rand.nextInt(i);

            Utils.swap(nums, i - 1, index);
        }
    }
}
