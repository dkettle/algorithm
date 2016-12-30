/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * _380_Insert_Delete_GetRandom
 *
 * @author xuhaoran01
 */
public class _380_Insert_Delete_GetRandom {

    public static void main(String[] args) {

        RandomizedSet rs = new RandomizedSet();
        rs.insert(1);
        rs.remove(1);
        rs.getRandom();
    }

    /**
     * RandomizedSet
     *
     * @author xuhaoran01
     */
    public static class RandomizedSet {

        List<Integer> list = new ArrayList<>(); // elements
        Map<Integer, Integer> map = new HashMap<>(); // elem, index
        Random random = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {

            if (map.containsKey(val)) {
                return false;
            }

            map.put(val, list.size());
            list.add(val);

            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {

            if (!map.containsKey(val)) {
                return false;
            }

            int lastVal = list.get(list.size() - 1);
            map.put(lastVal, map.get(val));
            Collections.swap(list, map.get(val), list.size() - 1);
            list.remove(list.size() - 1);
            map.remove(val);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {

            int index = random.nextInt(list.size());

            return list.get(index);
        }
    }
}
