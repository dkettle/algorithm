/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearchtree;

import java.util.TreeMap;

/**
 * _732_My_Calendar_III
 *
 * @author xuhaoran01
 */
public class _732_My_Calendar_III {
    class MyCalendarThree {

        private TreeMap<Integer, Integer> map;

        public MyCalendarThree() {
            map = new TreeMap<>();
        }

        public int book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);

            int active = 0, res = 0;
            for (int d : map.values()) {
                active += d;
                res = Math.max(active, res);
            }

            return res;
        }
    }
}
