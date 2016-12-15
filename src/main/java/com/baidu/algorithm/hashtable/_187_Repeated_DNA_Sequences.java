/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * _187_Repeated_DNA_Sequences
 *
 * @author xuhaoran01
 */
public class _187_Repeated_DNA_Sequences {

    public List<String> findRepeatedDnaSequences1(String s) {

        List<String> res = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {

            String str = s.substring(i, i + 10);
            Integer num = map.getOrDefault(str, 0);
            if (num == 1) {
                res.add(str);
            }

            map.put(str, num + 1);
        }

        return res;
    }

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> res = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();

        int[] bit = new int[26];
        bit['C' - 'A'] = 1;
        bit['G' - 'A'] = 2;
        bit['T' - 'A'] = 3;

        char[] chars = s.toCharArray();
        for (int i = 0; i <= chars.length - 10; i++) {
            int v = 0;
            for (int j = i; j < i + 10; j++) {
                v |= bit[chars[j] - 'A'];
                v <<= 2;
            }

            int cnt = mp.getOrDefault(v, 0);
            if (cnt == 1) {
                res.add(s.substring(i, i + 10));
            }
            mp.put(v, cnt + 1);
        }

        return res;
    }
}
