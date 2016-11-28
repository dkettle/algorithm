/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _165_Compare_Version_Numbers
 *
 * @author xuhaoran01
 */
public class _165_Compare_Version_Numbers {

    private boolean isAllZero(String str) {

        if (str == null || str.length() == 0) {
            return true;
        }

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != '0' && str.charAt(i) != '.') {
                return false;
            }
        }

        return true;
    }

    public int compareVersion(String version1, String version2) {

        if (isAllZero(version1) && !isAllZero(version2)) {
            return -1;
        } else if (!isAllZero(version1) && isAllZero(version2)) {
            return 1;
        } else if (version1.equals(version2)) {
            return 0;
        }

        int index1 = version1.indexOf('.');
        int index2 = version2.indexOf('.');
        String str1 = index1 != -1 ? version1.substring(0, index1) : version1;
        String str2 = index2 != -1 ? version2.substring(0, index2) : version2;

        int cmp = Integer.valueOf(str1) - Integer.valueOf(str2);

        if (cmp != 0) {
            return cmp > 0 ? 1 : -1;
        } else if (index1 == -1 && index2 == -1) {
            return 0;
        } else if (index1 == -1) {
            if (isAllZero(version2.substring(index2 + 1))) {
                return 0;
            }
            return -1;
        } else if (index2 == -1) {
            if (isAllZero(version1.substring(index1 + 1))) {
                return 0;
            }
            return 1;
        } else {
            return compareVersion(version1.substring(index1 + 1), version2.substring(index2 + 1));
        }
    }


    public int compareVersion1(String version1, String version2) {

        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");

        int maxLen = Math.max(str1.length, str2.length);
        for (int i = 0; i < maxLen; i++) {
            int v1 = i < str1.length ? Integer.parseInt(str1[i]) : 0;
            int v2 = i < str2.length ? Integer.parseInt(str2[i]) : 0;

            if (v1 != v2) {
                return v1 > v2 ? 1 : -1;
            }
        }

        return 0;
    }

    public int compareVersion2(String version1, String version2) {

        int len1 = version1.length(), len2 = version2.length();
        int i = 0, j = 0;

        while (i < len1 || j < len2) {
            int v1 = 0, v2 = 0;

            while (i < len1 && version1.charAt(i) != '.') {
                v1 = v1 * 10 + version1.charAt(i) - '0';
                i++;
            }

            while (j < len2 && version2.charAt(j) != '.') {
                v2 = v2 * 10 + version2.charAt(j) - '0';
                j++;
            }

            if (v1 != v2) {
                return v1 > v2 ? 1 : -1;
            }

            i++;
            j++;
        }

        return 0;
    }

    public static void main(String[] args) {
        new _165_Compare_Version_Numbers().compareVersion1("1", "1.1");
    }
}
