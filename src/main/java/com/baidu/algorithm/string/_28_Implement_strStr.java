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

    private List<Integer> getNext(String str) {

        int len = str.length();
        int[] next = new int[len + 1];

        int i = 1, j = 0;
        while (i < len) {
            if (str.charAt(i) == str.charAt(j)) {
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

        return IntStream.of(next).boxed().collect(Collectors.toList());
    }

    // kmp
    public int strStr(String s, String t) {

        int sLen = s.length(), tLen = t.length();
        if (sLen < tLen) {
            return -1;
        }
        else if (tLen == 0) {
            return 0;
        }

        List<Integer> next = getNext(t);
        int i = 0, j = 0;
        while (j < tLen && i < sLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                if (j == tLen) {
                    return i - tLen;
                }
            }
            else if (j > 0) {
                j = next.get(j);
            }
            else {
                i++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String s = "aabaaabaaac";
        String t = "aabaaac";

        new _28_Implement_strStr().strStr(s, t);
    }
}
