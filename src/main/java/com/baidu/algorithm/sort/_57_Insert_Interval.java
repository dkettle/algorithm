/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _57_Insert_Interval
 *
 * @author xuhaoran01
 */
public class _57_Insert_Interval {

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

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        if (newInterval == null) {
            return intervals;
        } else if (intervals == null || intervals.isEmpty()) {
            return Arrays.asList(newInterval);
        } else if (newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        } else if (newInterval.start > intervals.get(intervals.size() - 1).end) {
            intervals.add(newInterval);
            return intervals;
        } else {
            List<Interval> res = new ArrayList<>();

            int i = 0;
            while (i < intervals.size()) {
                if (intervals.get(i).end < newInterval.start) {
                    res.add(intervals.get(i));
                    i++;
                } else {
                    if (intervals.get(i).start > newInterval.end) {
                        res.add(newInterval);
                    } else {
                        int j = i + 1, start = Math.min(newInterval.start, intervals.get(i).start);
                        while (j < intervals.size() && newInterval.end >= intervals.get(j).start) {
                            j++;
                        }
                        res.add(new Interval(start, Math.max(newInterval.end, intervals.get(j - 1).end)));
                        i = j;
                    }
                    break;
                }
            }
            while (i < intervals.size()) {
                res.add(intervals.get(i));
                i++;
            }
            return res;
        }
    }
}
