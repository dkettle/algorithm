/*
 Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.binarysearchtree;


import com.baidu.algorithm.sort._56_Merge_Intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * _352_Data_Stream_as_Disjoint_Intervals
 *
 * @author xuhaoran01
 */
public class _352_Data_Stream_as_Disjoint_Intervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    class SummaryRanges {

        TreeMap<Integer, Interval> tree;

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
            tree = new TreeMap<>();
        }

        public void addNum(int val) {
            if (tree.containsKey(val)) {
                return;
            }

            Integer lKey = tree.lowerKey(val);
            Integer hKey = tree.higherKey(val);
            if (lKey != null && hKey != null && tree.get(lKey).end == val - 1 && hKey == val + 1) {
                tree.get(lKey).end = tree.get(hKey).end;
                tree.remove(hKey);
            } else if (lKey != null && tree.get(lKey).end + 1 >= val) {
                tree.get(lKey).end = Math.max(tree.get(lKey).end, val);
            } else if (hKey != null && hKey == val + 1) {
                tree.put(val, new Interval(val, tree.get(hKey).end));
                tree.remove(hKey);
            } else {
                tree.put(val, new Interval(val, val));
            }

        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(tree.values());
        }
    }
}
