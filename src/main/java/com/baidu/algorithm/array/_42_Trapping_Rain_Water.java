/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _42_Trapping_Rain_Water
 *
 * @author xuhaoran01
 */
public class _42_Trapping_Rain_Water {

    // O(n) space
    public int trap1(int[] height) {

        if (height == null || height.length <= 2) {
            return 0;
        }

        int n = height.length, res = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        int cur = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = cur;
            cur = Math.max(cur, height[i]);
        }

        cur = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = cur;
            cur = Math.max(cur, height[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            res += Math.max(Math.min(left[i], right[i]) - height[i], 0);
        }

        return res;
    }

    // O(1) space
    public int trap(int[] height) {

        int n = height.length, left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0, res = 0;

        while (left <= right) {

            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                }
                else {
                    res += leftMax - height[left];
                }
                left++;
            }
            else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                }
                else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }

        return res;
    }
}
