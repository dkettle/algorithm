/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

/**
 * _389_Find_the_Difference
 *
 * @author xuhaoran01
 */
public class _389_Find_the_Difference {

    public char findTheDifference(String s, String t) {

        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            count[c]--;
        }

        for (char c : t.toCharArray()) {
            count[c]++;
        }

        char res = '0';
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                res = (char) i;
            }
        }

        return res;
    }
}
