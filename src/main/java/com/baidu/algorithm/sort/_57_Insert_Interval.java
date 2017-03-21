/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * _57_Insert_Interval
 *
 * @author xuhaoran01
 */
public class _57_Insert_Interval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
        }
        else {
            int len = intervals.size();
            if (newInterval.end < intervals.get(0).start) {
                intervals.add(0, newInterval);
                res = intervals;
            }
            else if (newInterval.start > intervals.get(len - 1).end) {
                intervals.add(newInterval);
                res = intervals;
            }
            else {
                int index1 = 0, index2 = 0;
                while (index1 < len) {
                    if (newInterval.start <= intervals.get(index1).end) {
                        index2 = index1;
                        break;
                    }
                    index1++;
                }

                while (index2 < len) {
                    if (newInterval.end < intervals.get(index2).start) {
                        break;
                    }
                    index2++;
                }

                for (int i = 0; i < index1; i++) {
                    res.add(intervals.get(i));
                }
                res.add(new Interval(Math.min(newInterval.start, intervals.get(index1).start),
                                            Math.max(newInterval.end, intervals.get(index2 - 1).end)));
                for (int i = index2; i < len; i++) {
                    res.add(intervals.get(i));
                }
            }
        }

        return res;
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
