/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _67_Add_Binary
 *
 * @author xuhaoran01
 */
public class _67_Add_Binary {

    public String addBinary(String a, String b) {

        int aLen = a.length(), bLen = b.length();
        if (aLen > bLen) {
            return addBinary(b, a);
        }

        String res = "";
        int carry = 0;

        while (aLen > 0 && bLen > 0) {
            int v1 = a.charAt(aLen - 1) == '0' ? 0 : 1;
            int v2 = b.charAt(bLen - 1) == '0' ? 0 : 1;

            res = ((v1 + v2 + carry) & 1) + res;
            carry = (v1 + v2 + carry) >> 1;

            aLen--;
            bLen--;
        }

        while (bLen > 0) {
            int sum = carry + (b.charAt(bLen - 1) == '0' ? 0 : 1);

            res = (sum & 1) + res;
            carry = sum >> 1;

            bLen--;
        }

        if (carry > 0) {
            res = carry + res;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 + "a");

        new _67_Add_Binary().addBinary("11", "1");
    }
}
