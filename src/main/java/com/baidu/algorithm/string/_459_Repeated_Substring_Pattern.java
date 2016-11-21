/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _459_Repeated_Substring_Pattern
 *
 * @author xuhaoran01
 */
public class _459_Repeated_Substring_Pattern {

    private boolean isLegal(String str, String substr, int len) {

        for (int i = len; i < str.length(); i += len) {
            if (!str.substring(i, i + len).equals(substr)) {
                return false;
            }
        }

        return true;
    }

    public boolean repeatedSubstringPattern(String str) {

        if (str == null || str.length() <= 1) {
            return false;
        }

        int n = str.length();
        if (isLegal(str, str.substring(0, 1), 1)) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            int j = n / i;
            if (i * j == n) {
                if (isLegal(str, str.substring(0, j), j)) {
                    return true;
                }
                if (isLegal(str, str.substring(0, i), i)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        new _459_Repeated_Substring_Pattern().repeatedSubstringPattern("abab");
    }
}
