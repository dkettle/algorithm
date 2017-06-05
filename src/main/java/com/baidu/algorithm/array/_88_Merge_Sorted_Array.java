/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.array;

/**
 * _88_Merge_Sorted_Array
 *
 * @author xuhaoran01
 */
public class _88_Merge_Sorted_Array {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        while (m > 0 && n > 0) {
            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
            else {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            }
        }

        while (n > 0) {
            nums1[n - 1] = nums2[n - 1];
            n--;
        }
    }
}
