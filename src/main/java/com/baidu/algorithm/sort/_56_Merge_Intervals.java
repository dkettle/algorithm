/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * _56_Merge_Intervals
 *
 * @author xuhaoran01
 */
public class _56_Merge_Intervals {

    public List<Interval> merge(List<Interval> intervals) {


        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }

        List<Interval> res = new ArrayList<>();

        Collections.sort(intervals, (x, y) -> x.start - y.start);

        int i = 1, len = intervals.size();
        Interval interval = intervals.get(0);

        while (i < len) {
            if (intervals.get(i).start <= interval.end) {
                interval = new Interval(interval.start, Math.max(interval.end, intervals.get(i).end));
            }
            else {
                res.add(interval);
                interval = intervals.get(i);
            }
            i++;
        }

        res.add(interval);

        return res;
    }

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
}
