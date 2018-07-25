/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.string;

import java.util.Collections;

/**
 * ReverseString
 *
 * @author xuhaoran01
 */
public class ReverseString {

    public String reverse(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString().reverse("abcdce"));
    }
}
