/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * _30_Substring_with_Concatenation_of_All_Words
 *
 * @author xuhaoran01
 */
public class _30_Substring_with_Concatenation_of_All_Words {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }

        int sLen = s.length(), wLen = words[0].length(), wsLen = words.length;
        Map<String, Integer> mp = new HashMap<>();
        for (String word : words) {
//            mp.put(word, mp.containsKey(word) ? mp.get(word) + 1 : 1);
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= sLen - wLen * wsLen; i++) {

            Map<String, Integer> temp = new HashMap<>(mp);
            for (int j = 0; j < wsLen; j++) {

                int index = i + j * wLen;
                String word = s.substring(index, index + wLen);
                if (temp.containsKey(word)) {
                    temp.put(word, temp.get(word) - 1);
                    if (temp.get(word) == 0) {
                        temp.remove(word);
                    }
                }
                else {
                    break;
                }
            }

            if (temp.size() == 0) {
                res.add(i);
            }
        }

        return res;
    }
}
