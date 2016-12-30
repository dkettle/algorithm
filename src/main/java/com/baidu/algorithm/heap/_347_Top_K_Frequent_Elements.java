/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.IntStream;

import com.baidu.algorithm.annotation.Note;

/**
 * _347_Top_K_Frequent_Elements
 *
 * @author xuhaoran01
 */
public class _347_Top_K_Frequent_Elements {

    @Note(desc = "Map.Entry usage")
    // PriorityQueue
    public List<Integer> topKFrequent2(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : nums) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
        mp.entrySet().stream().forEach(pq::offer);

        while (k > 0) {
            res.add(pq.poll().getKey());
            k--;
        }

        return res;
    }

    @Note(desc = "addAll param can not be null")
    // bucket sort
    public List<Integer> topKFrequent1(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : nums) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }

        mp.entrySet().stream().forEach(x -> {
            int index = x.getValue();
            if (bucket[index] == null) {
                bucket[index] = new ArrayList<Integer>();
            }
            bucket[index].add(x.getKey());
        });

        for (int i = nums.length; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }

        return res;
    }

    @Note(desc = "TreeMap usage")
    // tree map
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<>();
        IntStream.of(nums).forEach(x -> mp.put(x, mp.getOrDefault(x, 0) + 1));

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        mp.entrySet().stream().forEach(x -> {
            List<Integer> list = treeMap.get(x.getValue());
            if (list == null) {
                list = new ArrayList<Integer>();
            }
            list.add(x.getKey());
            treeMap.put(x.getValue(), list);
        });

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            res.addAll(treeMap.pollLastEntry().getValue());
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        new _347_Top_K_Frequent_Elements().topKFrequent(nums, 2);
    }
}
