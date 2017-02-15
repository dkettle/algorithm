/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearch;

/**
 * _278_First_Bad_Version
 *
 * @author xuhaoran01
 */
public class _278_First_Bad_Version {

    boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {

        int left = 1, right = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}
