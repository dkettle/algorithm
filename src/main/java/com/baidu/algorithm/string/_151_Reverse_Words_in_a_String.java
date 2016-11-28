/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.regex.Pattern;

/**
 * _151_Reverse_Words_in_a_String
 *
 * @author xuhaoran01
 */
public class _151_Reverse_Words_in_a_String {

    public String reverseWords(String s) {

        if (s == null || s.length() == 0 || s.indexOf(' ') == -1) {
            return s;
        }

        s = s.trim().replaceAll(" +", " ");

        StringBuilder sb = new StringBuilder();
        int i = s.length(), j = i;
        while (i != -1) {
            i = s.lastIndexOf(' ', j - 1);
            sb.append(' ').append(s.substring(i + 1, j));

            j = i;
        }

        return sb.deleteCharAt(0).toString();
    }

    public String reverseWords1(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        s = s.trim().replaceAll("\\s+", " ");
        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(' ').append(words[i]);
        }

        return sb.deleteCharAt(0).toString();
    }

    public static void main(String[] args) {
        System.out.println(new _151_Reverse_Words_in_a_String().reverseWords1(" "));
    }
}
