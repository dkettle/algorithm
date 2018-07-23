/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.string;

/**
 * ReplaceSpace
 *
 * @author xuhaoran01
 */
public class ReplaceSpace {

    public String replaceSpace(String str) {
        if (str == null) {
            return null;
        }

        char[] chars = str.toCharArray();
        int space_num = 0;

        for (char c : chars) {
            if (c == ' ') {
                space_num++;
            }
        }

        char[] rs = new char[chars.length + 2 * space_num];
        for (int i = chars.length - 1, j = rs.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                rs[j--] = chars[i];
            }
            else {
                rs[j--] = '0';
                rs[j--] = '2';
                rs[j--] = '%';
            }
        }

        return String.valueOf(rs);
    }

    public static void main(String[] args) {

        ReplaceSpace rs = new ReplaceSpace();
        System.out.println(rs.replaceSpace("hello world hrxu "));
    }
}
