/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

/**
 * _202_Happy_Number
 *
 * @author xuhaoran01
 */
public class _202_Happy_Number {

    private int getNext(int n) {

        int res = 0;

        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }

        return res;
    }

    public boolean isHappy(int n) {

        int slow = n, fast = n;
        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while (slow != fast);

        return slow == 1;
    }
}
