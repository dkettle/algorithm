/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.baidu.algorithm.annotation.Note;

/**
 * _381_Insert_Delete_GetRandom
 *
 * @author xuhaoran01
 */
public class _381_Insert_Delete_GetRandom {

    public static void main(String[] args) {

        RandomizedCollection rc = new RandomizedCollection();
        rc.insert(1);
        rc.insert(1);
        rc.insert(2);
        rc.remove(1);
    }

    /**
     * RandomizedCollection
     *
     * @author xuhaoran01
     */
    public static class RandomizedCollection {

        List<Integer> vals = new ArrayList<>();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        Random rand = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {

        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {

            boolean res = Boolean.TRUE;
            if (mp.containsKey(val)) {
                res = Boolean.FALSE;
            }

            List<Integer> list = mp.getOrDefault(val, new ArrayList<>());
            list.add(vals.size());
            mp.put(val, list);

            vals.add(val);

            return res;
        }

        @Note(desc = "when iterate vals, can not modify val, orElse throw ConcurrentModificationException")
        @Note(desc = "remove index vs. remove object")
        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {

            if (!mp.containsKey(val)) {
                return false;
            }

            List<Integer> list = mp.get(val);
            list.sort((x, y) -> y - x);

            int index = list.get(list.size() - 1);
            int len = vals.size();
            if (index != len - 1) {
                int last = vals.get(len - 1);
                vals.set(index, last);

                mp.get(last).add(index);
                mp.get(last).remove(Integer.valueOf(len - 1));
            }

            vals.remove(len - 1);
            list.remove(list.size() - 1);

            if (list.size() == 0) {
                mp.remove(val);
            }

            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {

            int index = rand.nextInt(vals.size());

            return vals.get(index);
        }
    }
}
