/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearch;

/**
 * _4_Median_of_Two_Sorted_Arrays
 *
 * @author xuhaoran01
 */
public class _4_Median_of_Two_Sorted_Arrays {

//    private int findKthInSortedArrays(int[] num1, int s1, int m, int[] num2, int s2, int n, int k) {
//
//        if (m == 0) {
//            return num2[s2 + k - 1];
//        }
//        else if (n == 0) {
//            return num1[s1 + k - 1];
//        }
//        else if (k == 1) {
//            return Math.min(num1[s1], num2[s2]);
//        }
//        else if (m > n) {
//            return findKthInSortedArrays(num2, s2, n, num1, s1, m, k);
//        }
//
//        int p1 = Math.min(k >> 1, m), p2 = k - p1;
//        int val1 = num1[s1 + p1 - 1];
//        int val2 = num2[s2 + p2 - 1];
//
//        if (val1 == val2) {
//            return val1;
//        }
//        else if (val1 > val2) {
//            return findKthInSortedArrays(num1, s1, p1, num2, s2 + p2, n - p2, p1);
//        }
//        else {
//            return findKthInSortedArrays(num1, s1 + p1, m - p1, num2, s2, p2, p2);
//        }
//    }
//
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        int e1 = nums1.length, e2 = nums2.length;
//        int mid = (e1 + e2) >> 1;
//
//        if ((e1 + e2) % 2 == 1) {
//
//            return findKthInSortedArrays(nums1, 0, e1, nums2, 0, e2, mid + 1);
//        }
//        else {
//
//            return (double) (findKthInSortedArrays(nums1, 0, e1, nums2, 0, e2, mid) +
//                             findKthInSortedArrays(nums1, 0, e1, nums2, 0, e2, mid + 1)) / 2;
//        }
//    }

    public double findMedianSortedArrays(int[] nums1, int s1, int n1, int[] nums2, int s2, int n2, int k) {
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, s2, n2, nums1, s1, n1, k);
        }

        if (n1 == 0) {
            return nums2[s2 + k - 1];
        }
        else if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }

        int p1 = Math.min(k / 2, n1), p2 = k - p1;
        int v1 = nums1[s1 + p1 - 1], v2 = nums2[s2 + p2 - 1];

        if (v1 == v2) {
            return v1;
        }
        else if (v1 < v2) {
            return findMedianSortedArrays(nums1, s1 + p1, n1 - p1, nums2, s2, p2, p2);
        }
        else {
            return findMedianSortedArrays(nums1, s1, p1, nums2, s2 + p2, n2 - p2, p1);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int mid = (n1 + n2) / 2;

        if ((n1 + n2) % 2 == 1) {
            return findMedianSortedArrays(nums1, 0, n1, nums2, 0, n2, mid + 1);
        } else {
            return (findMedianSortedArrays(nums1, 0, n1, nums2, 0, n2, mid) +
                    findMedianSortedArrays(nums1, 0, n1, nums2, 0, n2, mid + 1)) / 2;
        }
    }
}
