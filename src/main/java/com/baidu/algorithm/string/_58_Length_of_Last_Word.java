/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _58_Length_of_Last_Word
 *
 * @author xuhaoran01
 */
public class _58_Length_of_Last_Word {

    public int lengthOfLastWord(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        return end - start;
    }

    public int lengthOfLastWord1(String s) {

        return s.trim().length() - s.trim().lastIndexOf(' ') - 1;
    }
}
