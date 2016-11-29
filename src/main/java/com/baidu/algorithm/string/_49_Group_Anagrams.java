/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * _49_Group_Anagrams
 *
 * @author xuhaoran01
 */
public class _49_Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> mp = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (mp.get(key) != null) {
                mp.get(key).add(str);
            }
            else {
                List<String> value = new ArrayList<>();
                value.add(str);
                mp.put(key, value);
            }
        }

        for (Map.Entry<String, List<String>> entry : mp.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
