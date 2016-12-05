/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * _93_Restore_IP_Addresses
 *
 * @author xuhaoran01
 */
public class _93_Restore_IP_Addresses {

    private boolean isLegel(String s) {
        String[] elements = s.split("\\.");

        for (String elem : elements) {
            if (elem.charAt(0) == '0' && elem.length() > 1) {
                return false;
            }

            if (Integer.parseInt(elem) > 255) {
                return false;
            }
        }

        return true;
    }

    private void restoreIpAddresses(String s, int n1, int n2, String str, List<String> res) {
        if (n1 == 4) {
            if (n2 == s.length() && isLegel(str)) {
                res.add(str.substring(0, str.length() - 1));
            }
            return;
        }

        for (int i = 1; i <= 3 && n2 + i <= s.length(); i++) {
            restoreIpAddresses(s, n1 + 1, n2 + i, str + s.substring(n2, n2 + i) + ".", res);
        }
    }

    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }

        restoreIpAddresses(s, 0, 0, "", res);

        return res;
    }

    public static void main(String[] args) {
        String s = "0.0.0.0.";
        String[] words = s.split("\\."); //必须加斜杠
        System.out.println(words.length);

        new _93_Restore_IP_Addresses().restoreIpAddresses("010010");
    }
}
