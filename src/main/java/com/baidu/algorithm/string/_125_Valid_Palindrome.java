/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import javax.print.DocFlavor;
import javax.print.attribute.IntegerSyntax;
import javax.sound.midi.Soundbank;

import com.baidu.algorithm.Note;

/**
 * _125_Valid_Palindrome
 *
 * @author xuhaoran01
 */
public class _125_Valid_Palindrome {

    // Character.isLetterOrDigit
    private boolean isAlphabetic(char c) {

        if ('A' <= c && c <= 'Z') {
            return true;
        }

        if ('a' <= c && c <= 'z') {
            return true;
        }

        if ('0' <= c && c <= '9') {
            return true;
        }

        return false;
    }

    public boolean isPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        while (i < j) {

            while (i < j && !isAlphabetic(s.charAt(i))) {
                i++;
            }

            while (i < j && !isAlphabetic(s.charAt(j))) {
                j--;
            }

            if (i < j && s.charAt(i) != s.charAt(j) && Math.abs(s.charAt(i) - s.charAt(j)) != 32) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public boolean isPalindrome1(String s) {

        String neat = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reverseStr = new StringBuilder(neat).reverse().toString();

        return reverseStr.equals(neat);
    }

    // '0' - 'P' == 32
    @Note(desc = "不可以根据差值判断大小字母")
    public static void main(String[] args) {
        System.out.println('0' - 'P');
        System.out.println('a');

        System.out.println((int) 'p');
        System.out.println((int) 'P');

        System.out.println((int) '0');
        System.out.println(Integer.parseInt(String.valueOf('0')));
    }
}
