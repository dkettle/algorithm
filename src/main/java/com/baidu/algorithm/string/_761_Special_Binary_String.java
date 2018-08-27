/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * _761_Special_Binary_String
 *
 * @author xuhaoran01
 */
public class _761_Special_Binary_String {
    public String makeLargestSpecial(String S) {
        if (S.isEmpty()) {
            return "";
        }

        List<String> ss = new ArrayList<>();
        int cnt = 0;
        for (int i = 0, j = 0; j < S.length(); j++) {
            char c = S.charAt(j);
            if (c == '1') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt == 0) {
                ss.add("1" + makeLargestSpecial(S.substring(i + 1, j)) + "0");
                i = j + 1;
            }
        }

        Collections.sort(ss, Collections.reverseOrder());
        return String.join("", ss);
    }
}
