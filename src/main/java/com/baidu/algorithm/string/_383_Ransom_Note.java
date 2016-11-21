/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

/**
 * _383_Ransom_Note
 *
 * @author xuhaoran01
 */
public class _383_Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote == null || ransomNote.length() == 0) {
            return true;
        } else if (magazine == null || magazine.length() == 0) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (--count[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
