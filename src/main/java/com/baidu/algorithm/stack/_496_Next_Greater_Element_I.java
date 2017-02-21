/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * _496_Next_Greater_Element_I
 *
 * @author xuhaoran01
 */
public class _496_Next_Greater_Element_I {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {

        Map<Integer, Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int v : nums) {
            while (!st.empty() && st.peek() < v) {
                mp.put(st.pop(), v);
            }
            st.push(v);
        }

        int[] res = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            res[i] = mp.getOrDefault(findNums[i], -1);
        }

        return res;
    }
}
