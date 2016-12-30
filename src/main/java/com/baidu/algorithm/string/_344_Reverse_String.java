/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _344_Reverse_String
 *
 * @author xuhaoran01
 */
public class _344_Reverse_String {

    public String reverseString_1(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String reverseString(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] ch = s.toCharArray();
        for (int i = 0, j = ch.length - 1; i < j; i++, j--) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(new _344_Reverse_String().reverseString("hello"));
    }
}
