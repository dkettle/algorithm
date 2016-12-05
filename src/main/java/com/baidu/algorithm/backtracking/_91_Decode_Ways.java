/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

/**
 * _91_Decode_Ways
 *
 * @author xuhaoran01
 */
public class _91_Decode_Ways {

    private Integer res = 0;

    private boolean isLegal(String s) {

        if (s.charAt(0) == '0' || Integer.parseInt(s) > 26) {
            return false;
        }

        return true;
    }

    private void numDecodings(String s, int index) {

        if (index == s.length()) {
            res++;
            return;
        }

        if (s.charAt(index) != '0') {
            numDecodings(s, index + 1);
        }

        if (index + 1 < s.length() && isLegal(s.substring(index, index + 2))) {
            numDecodings(s, index + 2);
        }
    }

    // time limit exceeded
    public int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        numDecodings(s, 0);

        return res;
    }

    public static void main(String[] args) {
        Integer i = 5;
        i++;
        System.out.println(i);

        System.out.println(new _91_Decode_Ways().numDecodings("1"));
    }
}
