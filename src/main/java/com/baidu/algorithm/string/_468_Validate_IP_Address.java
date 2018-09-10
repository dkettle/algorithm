/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _468_Validate_IP_Address
 *
 * @author xuhaoran01
 */
public class _468_Validate_IP_Address {

    private boolean validIPv4(String IP) {
        if (IP == null || IP.isEmpty() || IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
            return false;
        }

        String[] fields = IP.split("\\.");
        if (fields.length != 4) {
            return false;
        }

        for (String field : fields) {
            if (field.length() == 0 || field.length() > 3) {
                return false;
            }

            for (char c : field.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }

            if (Integer.valueOf(field) > 255) {
                return false;
            }

            if (field.length() > 1 && field.charAt(0) == '0') {
                return false;
            }
        }

        return true;
    }

    private boolean validIPv6(String IP) {
        if (IP == null || IP.isEmpty() || IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
            return false;
        }

        String[] fields = IP.split(":");
        if (fields.length != 8) {
            return false;
        }

        for (String field : fields) {
            if (field.length() > 4 || field.length() == 0) {
                return false;
            }

            for (char c : field.toCharArray()) {
                if (!Character.isDigit(c) && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')) {
                    return false;
                }
            }
        }

        return true;
    }

    public String validIPAddress(String IP) {

        if (validIPv4(IP)) {
            return "IPv4";
        } else if (validIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    public static void main(String[] args) {
        new _468_Validate_IP_Address().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    }
}
