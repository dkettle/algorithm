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

        int i = 0, j = height.length - 1;
        int res = 0;

        while (i < j) {
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                j--;
            }
            else {
                i++;
            }
        }

        return res;
    }
}
