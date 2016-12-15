/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.baidu.algorithm.Note;

/**
 * _350_Intersection_of_Two_Arrays_II
 *
 * @author xuhaoran01
 */
public class _350_Intersection_of_Two_Arrays_II {

    @Note(desc = "map.put clean usage")
    public int[] intersect1(int[] nums1, int[] nums2) {

        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : nums1) {
//            map.put(v, map.containsKey(v) ? 1 : map.get(v) + 1);
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        for (int v : nums2) {
            if (map.containsKey(v) && map.get(v) > 0) {
                res.add(v);
                map.put(v, map.get(v) - 1);
            }
        }

        return res.stream().mapToInt(x -> x).toArray();
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {

            while (i < nums1.length && nums1[i] < nums2[j]) {
                i++;
            }

            while (i < nums1.length && j < nums2.length && nums2[j] < nums1[i]) {
                j++;
            }

            while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }

        return res.stream().mapToInt(x -> x).toArray();
    }
}
