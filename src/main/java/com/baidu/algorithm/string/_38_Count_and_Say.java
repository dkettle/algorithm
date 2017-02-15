/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _38_Count_and_Say
 *
 * @author xuhaoran01
 */
public class _38_Count_and_Say {

    private String getNext(String str) {

        String res = "";

        int i = 0, n = str.length();
        while (i < n) {
            int j = i + 1;
            while (j < n && str.charAt(j) == str.charAt(i)) {
                j++;
            }

            res += String.valueOf(j - i) + str.charAt(i);

            i = j;
        }

        return res;
    }

    public String countAndSay(int n) {

        if (n < 1) {
            return "";
        }

        String str = "1";
        while (n > 1) {
            str = getNext(str);
            n--;
        }

        return str;
    }

    public static void main(String[] args) {
        new _38_Count_and_Say().countAndSay(2);
    }
}
