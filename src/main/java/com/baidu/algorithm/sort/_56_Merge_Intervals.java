/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _56_Merge_Intervals
 *
 * @author xuhaoran01
 */
public class _56_Merge_Intervals {

    public static void main(String[] args) {
        Interval i1 = new _56_Merge_Intervals().new Interval(1, 3);
        Interval i3 = new _56_Merge_Intervals().new Interval(8, 10);
        Interval i2 = new _56_Merge_Intervals().new Interval(2, 6);
        Interval i4 = new _56_Merge_Intervals().new Interval(15, 18);

        List<Interval> intervals = Arrays.asList(i1, i2, i3, i4);
        new _56_Merge_Intervals().merge(intervals);
    }

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

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            return res;
        }

        intervals.sort((x, y) -> x.start - y.start);
        int i = 0, n = intervals.size();
        while (i < n) {
            int j = i + 1, maxEnd = intervals.get(i).end;
            while (j < n && intervals.get(j).start <= maxEnd) {
                maxEnd = Math.max(maxEnd, intervals.get(j).end);
                j++;
            }

            res.add(new Interval(intervals.get(i).start, maxEnd));
            i = j;
        }

        return res;
    }
}
