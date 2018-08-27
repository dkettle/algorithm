/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearchtree;

import java.util.TreeMap;

/**
 * _729_My_Calendar_I
 *
 * @author xuhaoran01
 */
public class _729_My_Calendar_I {

    class MyCalendar {

        TreeMap<Integer, Integer> map;

        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer prev = map.floorKey(start);
            Integer next = map.ceilingKey(start);

            if ((prev == null || map.get(prev) <= start) && (next == null || next >= end)) {
                map.put(start, end);
                return true;
            }

            return false;
        }
    }
}
