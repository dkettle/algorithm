/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * _402_Remove_K_Digits
 *
 * @author xuhaoran01
 */
public class _402_Remove_K_Digits {

    // greedy
    public String removeKdigits(String num, int k) {

        if (num == null || num.length() == k) {
            return "0";
        }

        int len = num.length(), remain = len - k, top = 0;
        char[] st = new char[len];

        for (char c : num.toCharArray()) {

            while (top > 0 && c < st[top - 1] && k > 0) {
                top--;
                k--;
            }
            st[top++] = c;
        }

        int index = 0;
        while (index < remain && st[index] == '0') {
            index++;
        }

        return index == remain ? "0" : new String(st, index, remain - index);
    }

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        c.add(Calendar.DATE, 5); // Adding 5 days
        String output = sdf.format(c.getTime());
        System.out.println(output);
    }
}
