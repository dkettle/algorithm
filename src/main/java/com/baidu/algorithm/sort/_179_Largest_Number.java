/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * _179_Largest_Number
 *
 * @author xuhaoran01
 */
public class _179_Largest_Number {
    public String largestNumber(int[] nums) {
        List<String> strs = new ArrayList<>();
        for (int num : nums) {
            strs.add(String.valueOf(num));
        }

        Collections.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        String res = "";
        for (String str: strs) {
            res += str;
        }

        int i = 0;
        for (; i < res.length(); i++) {
            if (res.charAt(i) != '0') {
                break;
            }
        }
        return i == res.length() ? "0" : res.substring(i);
    }
}
