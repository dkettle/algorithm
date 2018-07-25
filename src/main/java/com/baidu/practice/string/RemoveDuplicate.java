/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.string;

/**
 * RemoveDuplicate
 *
 * @author xuhaoran01
 */
public class RemoveDuplicate {
    // a-z
    public String removeDuplicate(char[] chars) {

        int check = 0, j = 0;
        for (int i = 0; i < chars.length; i++) {
            int shift = chars[i] - 'a';
            if ((check & (1 << shift)) == 0) {
                chars[j++] = chars[i];
            }
            check |= (1 << shift);
        }

        chars[j] = '\0';

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicate().removeDuplicate(new char[]{'a', 'b', 'a', 'a', 'c'}));
    }
}
