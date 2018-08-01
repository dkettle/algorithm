/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.lang.reflect.Array;
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
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagram = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String sortStr = String.valueOf(chars);
            if (anagram.containsKey(sortStr)) {
                anagram.get(sortStr).add(str);
            } else {
                anagram.put(sortStr, new ArrayList<>(Arrays.asList(str)));
            }
        }


        return new ArrayList<>(anagram.values());
    }
}
