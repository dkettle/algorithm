/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.string;

/**
 * RotationString
 *
 * @author xuhaoran01
 */
public class RotationString {

    public boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    public boolean isRotate(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        } else if (s1 == null || s2 == null) {
            return false;
        } else if (s1.length() != s2.length()) {
            return false;
        }

        return isSubstring(s1 + s1, s2);
    }

    public static void main(String[] args) {

        RotationString rs = new RotationString();
        System.out.println(rs.isRotate("erbottlewat", "waterbottle"));
    }
}
