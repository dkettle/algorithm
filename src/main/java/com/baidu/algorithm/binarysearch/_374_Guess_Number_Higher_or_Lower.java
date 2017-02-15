/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearch;

/**
 * _374_Guess_Number_Higher_or_Lower
 *
 * @author xuhaoran01
 */
public class _374_Guess_Number_Higher_or_Lower {

    int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {

        int left = 1, right = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (guess(mid) == 0) {
                return mid;
            }
            else if (guess(mid) < 0) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return -1;
    }

}
