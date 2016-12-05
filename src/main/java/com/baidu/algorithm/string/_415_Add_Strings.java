/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.math.BigInteger;

/**
 * _415_Add_Strings
 *
 * @author xuhaoran01
 */
public class _415_Add_Strings {

    public String addStrings1(String num1, String num2) {

        return new BigInteger(num1).add(new BigInteger(num2)).toString();
    }

    public String addStrings(String num1, String num2) {

        int len1 = num1.length(), len2 = num2.length();
        if (len1 > len2) {
            return addStrings(num2, num1);
        }

        String res = "";
        int carry = 0;
        while (len1 > 0 && len2 > 0) {
            int sum = Integer.parseInt(String.valueOf(num1.charAt(len1 - 1))) +
                              Integer.parseInt(String.valueOf(num2.charAt(len2 - 1))) + carry;

            res = sum % 10 + res;
            carry = sum / 10;

            len1--;
            len2--;
        }

        while (len2 > 0) {
            int sum = Integer.parseInt(String.valueOf(num2.charAt(len2 - 1))) + carry;

            res = sum % 10 + res;
            carry = sum / 10;

            len2--;
        }

        if (carry > 0) {
            res = carry + res;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);

        new _415_Add_Strings().addStrings("6913259244", "71103343");
    }
}
