/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _880_Decoded_String_at_Index
 *
 * @author xuhaoran01
 */
public class _880_Decoded_String_at_Index {
    public String decodeAtIndex(String S, int K) {
        int n = S.length();
        long sz = 0;
        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                sz *= c - '0';
            } else {
                sz++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            char c = S.charAt(i);
            K %= sz;

            if (K == 0 && Character.isLetter(c)) {
                return "" + c;
            }

            if (Character.isDigit(c)) {
                sz /= c - '0';
            } else {
                sz--;
            }
        }

        return null;
    }
}
