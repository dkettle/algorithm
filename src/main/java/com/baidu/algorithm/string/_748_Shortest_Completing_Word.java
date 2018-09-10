/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * _748_Shortest_Completing_Word
 *
 * @author xuhaoran01
 */
public class _748_Shortest_Completing_Word {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        int cnt = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                map.put(c, map.getOrDefault(c, 0) + 1);
                cnt++;
            }
        }

        String res = null;
        for (String word : words) {
            Map<Character, Integer> tMap = new HashMap<>();
            int tCnt = 0;
            for (char c : word.toCharArray()) {
                tMap.put(c, tMap.getOrDefault(c, 0) + 1);
                if (tMap.get(c) <= map.getOrDefault(c, 0)) {
                    tCnt++;
                }
            }

            if (tCnt == cnt) {
                if (res == null || word.length() < res.length()) {
                    res = word;
                }
            }
        }

        return res;
    }
}
