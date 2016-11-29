/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _438_Find_All_Anagrams_in_a_String
 *
 * @author xuhaoran01
 */
public class _438_Find_All_Anagrams_in_a_String {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res= new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }

        int[] pCnt = new int[26];
        int[] sCnt = new int[26];

        char[] pArr = p.toCharArray();
        char[] sArr = s.toCharArray();

        for (char c : pArr) {
            pCnt[c - 'a']++;
        }

        int pLen = p.length();
        for (int i = 0; i < sArr.length; i++) {
            sCnt[sArr[i] - 'a']++;
            if (i >= pLen - 1) {
                if (Arrays.equals(pCnt, sCnt)) {
                    res.add(i - pLen + 1);
                }
                sCnt[sArr[i - pLen + 1] - 'a']--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new _438_Find_All_Anagrams_in_a_String().findAnagrams("cbaebabacd", "abc");
    }
}
