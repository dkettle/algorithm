/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.slidewindow;

/**
 * _76_Minimum_Window_Substring
 *
 * @author xuhaoran01
 */
public class _76_Minimum_Window_Substring {

    public String minWindow(String s, String t) {

        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] tCnt = new int[256];

        for (char c : t.toCharArray()) {
            tCnt[c]++;
        }

        int start = 0, minLen = Integer.MAX_VALUE, count = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tCnt[c]-- > 0) {
                count++;
            }

            while (count == t.length()) {
                if (i - j + 1 < minLen) {
                    minLen = i - j + 1;
                    start = j;
                }

                if (tCnt[s.charAt(j)]++ >= 0) { //只有t中字符才有可能>=0, 否则必然小于零
                    count--;
                }

                j++;
            }
        }

        return minLen < Integer.MAX_VALUE ? s.substring(start, start + minLen) : "";
    }

    public static void main(String[] args) {
        System.out.println(new _76_Minimum_Window_Substring().minWindow("ab", "b"));
    }
}
