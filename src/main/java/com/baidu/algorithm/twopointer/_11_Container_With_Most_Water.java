/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.twopointer;

/**
 * _11_Container_With_Most_Water
 *
 * @author xuhaoran01
 */
public class _11_Container_With_Most_Water {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            maxArea = Math.max(Math.min(height[i], height[j]) * (j - i), maxArea);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;
    }
}
