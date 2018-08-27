/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.twopointer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * _763_Partition_Labels
 *
 * @author xuhaoran01
 */
public class _763_Partition_Labels {

    private boolean canPartition(int[] count, Set<Character> set) {
        for (char c : set) {
            if (count[c - 'a'] != 0) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.isEmpty()) {
            return res;
        }

        int[] count = new int[26];
        for (char c : S.toCharArray()) {
            count[c - 'a']++;
        }

        Set<Character> visited = new HashSet<>();
        for (int i = 0, j = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            visited.add(c);
            if (--count[c - 'a'] == 0) {
                if (canPartition(count, visited)) {
                    res.add(i - j + 1);
                    j = i + 1;
                    visited = new HashSet<>();
                }
            }
        }

        return res;
    }
}
