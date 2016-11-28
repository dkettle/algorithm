/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _273_Integer_to_English_Words
 *
 * @author xuhaoran01
 */
public class _273_Integer_to_English_Words {

    private String littleNumberTowords(int num) {

        String[] units = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                          "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                          "Eighteen", "Nineteen", "Twenty"};
        String[] decades = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        StringBuilder sb = new StringBuilder();

        if (num >= 100) {
            sb.append(' ').append(units[num / 100 - 1]);
            sb.append(' ').append("Hundred");

            num %= 100;
        }

        if (num > 20) {
            int high = num / 10;
            sb.append(' ').append(decades[high - 2]);

            int low = num % 10;
            if (low > 0) {
                sb.append(' ').append(units[low - 1]);
            }
        } else if (num > 0) {
            sb.append(' ').append(units[num - 1]);
        }

        return sb.deleteCharAt(0).toString();
    }

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        String[] postfix = {"Thousand", "Million", "Billion", "Trillion"};

        String res = "";
        int index = 0;
        while (num > 0) {
            if (num % 1000 > 0) {
                if (index > 0) {
                    res = " " + postfix[index - 1] + res;
                }
                res = " " + littleNumberTowords(num % 1000) + res;
            }

            num /= 1000;
            index++;
        }

        return res.trim();
    }

    public static void main(String[] args) {
        new _273_Integer_to_English_Words().numberToWords(123);
    }
}
