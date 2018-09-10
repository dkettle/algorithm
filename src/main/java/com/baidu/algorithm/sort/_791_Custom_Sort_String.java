/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * _791_Custom_Sort_String
 *
 * @author xuhaoran01
 */
public class _791_Custom_Sort_String {

    public String customSortString(String S, String T) {
        if (T == null || T.isEmpty()) {
            return T;
        }

        int[] count = new int[26];
        for (int i = 0; i < T.length(); i++) {
            count[T.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            while (count[c - 'a'] > 0) {
                count[c - 'a']--;
                sb.append(c);
            }
        }

        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a'] > 0) {
                count[c - 'a']--;
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(1 + 'a');

        System.out.println((char) (1 + 'a'));
    }
}
