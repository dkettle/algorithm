/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _214_Shortest_Palindrome
 *
 * @author xuhaoran01
 */
public class _214_Shortest_Palindrome {

    // time limit exceeded
    public String shortestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        String reverseStr = new StringBuilder(s).reverse().toString();

        int index = 0, len = s.length();
        while (index < len) {
            if (reverseStr.substring(index).equals(s.substring(0, len - index))) {
                break;
            }

            index++;
        }

        return reverseStr.substring(0, index) + s;
    }

    public String shortestPalindrome1(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        int i = 0, end = s.length() - 1, j = end;

        while (i < j) {
            if (chars[i] != chars[j]) {
                end--;
                i = 0;
                j = end;
            }
            else {
                i++;
                j--;
            }
        }

        return new StringBuilder(s.substring(end + 1)).reverse().append(s).toString();
    }

    public static void main(String[] args) {
        System.out.println(new _214_Shortest_Palindrome().shortestPalindrome("abc"));
    }
}
