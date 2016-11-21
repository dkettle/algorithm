/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.List;
import java.util.Stack;

/**
 * _385_Mini_Parser
 *
 * @author xuhaoran01
 */
public class _385_Mini_Parser {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    public static class NestedInteger {
        public NestedInteger() {}

        public NestedInteger(int value){}

        public boolean isInteger(){
            return true;
        }

        public Integer getInteger() {
            return 0;
        }

        public void setInteger(int value) {}

        public void add(NestedInteger ni) {}

        public List<NestedInteger> getList() {
            return null;
        }
    }

    public NestedInteger deserialize(String s) {

        NestedInteger res = new NestedInteger();

        if (s == null || s.length() == 0) {
            return res;
        }

        if (s.charAt(0) != '[') {

            res.setInteger(Integer.parseInt(s));

        } else {

            int count = 0, l = 1;
            for (int r = 1; r < s.length(); r++) {
                char c = s.charAt(r);
                if (count == 0 && (c == ',' || r == s.length() - 1)) {
                    res.add(deserialize(s.substring(l, r)));
                    l = r + 1;
                } else if (c == '[') {
                    count++;
                } else if (c == ']') {
                    count--;
                }
            }
        }

        return res;
    }

    public NestedInteger deserializeIter(String s) {

        NestedInteger res = new NestedInteger();
        if (s == null || s.length() == 0) {
            return res;
        } else if (s.charAt(0) != '[') {
            res.setInteger(Integer.parseInt(s));
            return res;
        }

        Stack<NestedInteger> st = new Stack<>();
        res = null;
        int l = 0, r = 0;

        for (; r < s.length(); r++) {
            char c = s.charAt(r);
            if (c == '[') {
                if (res != null) {
                    st.push(res);
                }
                res = new NestedInteger();
                l = r + 1;
            } else if (c == ']') {
                if (l != r) {
                    res.add(new NestedInteger(Integer.parseInt(s.substring(l, r))));
                }

                if (!st.isEmpty()) {
                    NestedInteger top = st.pop();
                    top.add(res);
                    res = top;
                }
                l = r + 1;
            } else if (c == ',') {
                if (s.charAt(r - 1) != ']') {
                    res.add(new NestedInteger(Integer.parseInt(s.substring(l, r))));
                }
                l = r + 1;
            }
        }

        return res;
    }

}
