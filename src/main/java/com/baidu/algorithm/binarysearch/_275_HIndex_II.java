/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearch;

/**
 * _275_HIndex_II
 *
 * @author xuhaoran01
 */
public class _275_HIndex_II {

    public int hIndex(int[] citations) {

        if (citations == null || citations.length == 0) {
            return 0;
        }

        int len = citations.length, left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (citations[mid] > len - mid) {
                right = mid - 1;
            } else if (citations[mid] == len - mid) {
                return len - mid;
            } else {
                left = mid + 1;
            }
        }

        return len - left;
    }
}
