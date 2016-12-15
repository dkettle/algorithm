/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * _205_Isomorphic_Strings
 *
 * @author xuhaoran01
 */
public class _205_Isomorphic_Strings {

    // same with 290
    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (mp.containsKey(ch1) && mp.get(ch1) != ch2 || (!mp.containsKey(ch1) && mp.containsValue(ch2))) {
                return false;
            }

            mp.put(ch1, ch2);
        }

        return true;
    }
}
