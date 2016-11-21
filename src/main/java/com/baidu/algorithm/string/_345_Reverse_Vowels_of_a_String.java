/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * _345_Reverse_Vowels_of_a_String
 *
 * @author xuhaoran01
 */
public class _345_Reverse_Vowels_of_a_String {

    public String reverseVowels(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {

            while (i < j && !vowels.contains(s.charAt(i))) {
                i++;
            }

            while (i < j && !vowels.contains(s.charAt(j))) {
                j--;
            }

            if (i < j) {
                char tmp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, tmp);
            }
        }

        return sb.toString();
    }
}
