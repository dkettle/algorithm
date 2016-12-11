/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.PriorityQueue;

import javafx.util.Pair;

/**
 * _451_Sort_Characters_By_Frequency
 *
 * @author xuhaoran01
 */
public class _451_Sort_Characters_By_Frequency {

    public String frequencySort(String s) {

        if (s == null || s.length() <= 2) {
            return s;
        }

        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        PriorityQueue<Pair<Character, Integer>> pq =
                new PriorityQueue<>((x, y) -> y.getValue().compareTo(x.getValue()));

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                pq.offer(new Pair<>((char)i, count[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair<Character, Integer> pair = pq.poll();
            for (int i = 0; i < pair.getValue(); i++) {
                sb.append(pair.getKey());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        new _451_Sort_Characters_By_Frequency().frequencySort("abb");
    }
}
