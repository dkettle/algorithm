/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearchtree;

import java.util.TreeMap;

/**
 * _731_My_Calendar_II
 *
 * @author xuhaoran01
 */
public class _731_My_Calendar_II {

    class MyCalendarTwo {

        private TreeMap<Integer, Integer> map;

        public MyCalendarTwo() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);

            int active = 0;
            for (int d : map.values()) {
                active += d;
                if (active >= 3) {
                    map.put(start, map.getOrDefault(start, 0) - 1);
                    map.put(end, map.getOrDefault(end, 0) + 1);
                    return false;
                }
            }

            return true;
        }
    }
}
