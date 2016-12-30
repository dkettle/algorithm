/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.baidu.algorithm.annotation.Note;

/**
 * _349_Intersection_of_Two_Arrays
 *
 * @author xuhaoran01
 */
public class _349_Intersection_of_Two_Arrays {

    @Note(desc = "list<integer> to int array")
    public int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> res = new LinkedList<>();

        Set<Integer> set = new HashSet<>();
        for (int v : nums1) {
            set.add(v);
        }

        for (int v : nums2) {
            if (set.contains(v)) {
                res.add(v);
                set.remove(v);
            }
        }

        return res.stream().mapToInt(x -> x).toArray();
    }

    @Note(desc = "int array to Integer array and Integer list")
    public static void main(String[] args) {

        int[] data = {1,2,3,4,5,6,7,8,9,10};
        Integer[] what = Arrays.stream(data).boxed().toArray(Integer[]::new);
        Integer[] ever = IntStream.of(data).boxed().toArray(Integer[]::new);

        // To boxed list
        List<Integer> you  = Arrays.stream( data ).boxed().collect( Collectors.toList() );
        List<Integer> like = IntStream.of( data ).boxed().collect( Collectors.toList() );
    }
}
