/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import com.baidu.algorithm.annotation.Note;

/**
 * _125_Valid_Palindrome
 *
 * @author xuhaoran01
 */
public class _125_Valid_Palindrome {

    public boolean isPalindrome(String s) {
        char[] chs = s.toCharArray();
        for(int i = 0, j = chs.length - 1; i < j;) {
            if(!Character.isLetterOrDigit(chs[i])) {
                i++;
                continue;
            }

            if(!Character.isLetterOrDigit(chs[j])) {
                j--;
                continue;
            }

            if(Character.toLowerCase(chs[i]) != Character.toLowerCase(chs[j])) {
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
