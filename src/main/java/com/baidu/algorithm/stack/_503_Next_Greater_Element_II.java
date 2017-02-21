/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * _503_Next_Greater_Element_II
 *
 * @author xuhaoran01
 */
public class _503_Next_Greater_Element_II {

    public int[] nextGreaterElements(int[] nums) {

        int len = nums.length;
        int res[] = new int[len];

        Arrays.fill(res, -1);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * len; i++) {
            while (!st.empty() && nums[st.peek()] < nums[i % len]) {
                res[st.pop()] = nums[i % len];
            }

            if (i < len) {
                st.push(i);
            }
        }

        return res;
    }
}
