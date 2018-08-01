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

    public static void main(String[] args) {
        System.out.println(new _76_Minimum_Window_Substring().minWindow("ab", "b"));
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        int[] tCnt = new int[256];
        for (char c : t.toCharArray()) {
            tCnt[c]++;
        }

        int start = 0, minLen = Integer.MAX_VALUE, count = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (tCnt[c]-- > 0) {
                count++;
            }

            while (count == t.length()) {
                if (tCnt[s.charAt(i)]++ >= 0) {
                    count--;

                    if (j - i + 1 < minLen) {
                        start = i;
                        minLen = j - i + 1;
                    }
                }
                i++;
            }
        }

        return minLen < Integer.MAX_VALUE ? s.substring(start, start + minLen) : "";
    }
}
