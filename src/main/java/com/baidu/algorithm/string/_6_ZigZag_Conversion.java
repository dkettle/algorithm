/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * _6_ZigZag_Conversion
 *
 * @author xuhaoran01
 */
public class _6_ZigZag_Conversion {

    public String convert(String s, int numRows) {

        if (numRows <= 1 || s.length() <= 2) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        StringBuilder res = new StringBuilder();

        int index = 0, len = s.length();
        while (index < len) {
            for (int i = 0; i < numRows && index < len; i++, index++) {
                list.get(i).append(s.charAt(index));
            }

            for (int i = numRows - 2; i > 0 && index < len; i--, index++) {
                list.get(i).append(s.charAt(index));
            }
        }

        for (StringBuilder sb : list) {
            res.append(sb);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        new _6_ZigZag_Conversion().convert("abc", 3);
    }
}
