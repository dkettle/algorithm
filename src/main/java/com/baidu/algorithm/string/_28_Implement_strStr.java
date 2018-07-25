/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * _28_Implement_strStr
 *
 * @author xuhaoran01
 */
public class _28_Implement_strStr {

    public static void main(String[] args) {

        String s = "aabaaabaaac";
        String t = "aabaaac";

        new _28_Implement_strStr().strStr(s, t);
    }

    private int[] getNext(String t) {
        int len = t.length();
        int[] next = new int[len + 1];

        int i = 1, j = 0;
        while (i < len) {
            if (t.charAt(i) == t.charAt(j)) {
                next[i + 1] = j + 1;
                i++;
                j++;
            }
            else if (j > 0) {
                j = next[j];
            }
            else {
                i++;
            }
        }

        return next;
    }

    public int strStr(String haystack, String needle) {
        int hLen = haystack.length(), nLen = needle.length();
        if (hLen < nLen) {
            return -1;
        }
        else if (nLen == 0) {
            return 0;
        }

        int[] next = getNext(needle);
        int i = 0, j = 0;
        while (i < hLen && j < nLen) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            else if (j > 0) {
                j = next[j];
            }
            else {
                i++;
            }
        }

        return j == nLen ? i - nLen : -1;
    }
}
