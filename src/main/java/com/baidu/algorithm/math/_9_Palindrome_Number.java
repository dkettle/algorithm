/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.math;

/**
 * _9_Palindrome_Number
 *
 * @author xuhaoran01
 */
public class _9_Palindrome_Number {

    public boolean isPalindrome(int x) {

        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }

        return (x == rev || x == rev / 10);
    }
}
