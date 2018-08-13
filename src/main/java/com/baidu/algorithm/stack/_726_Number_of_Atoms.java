/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * _726_Number_of_Atoms
 *
 * @author xuhaoran01
 */
public class _726_Number_of_Atoms {

    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> st = new Stack<>();
        Map<String, Integer> map = new TreeMap<>();

        int n = formula.length();
        for (int i = 0; i < n; ) {
            char c = formula.charAt(i);
            i++;

            if (c == '(') {
                st.push(map);
                map = new TreeMap<>();
            } else if (c == ')') {
                int val = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    val = val * 10 + formula.charAt(i) - '0';
                    i++;
                }

                val = val == 0 ? 1 : val;

                Map<String, Integer> tmp = map;
                map = st.pop();

                for (String atom : tmp.keySet()) {
                    map.put(atom, map.getOrDefault(atom, 0) + tmp.get(atom) * val);
                }
            } else {
                int start = i - 1;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }

                String atom = formula.substring(start, i);

                int val = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    val = val * 10 + formula.charAt(i) - '0';
                    i++;
                }

                val = val == 0 ? 1 : val;

                map.put(atom, map.getOrDefault(atom, 0) + val);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String atom : map.keySet()) {
            sb.append(atom);
            if (map.get(atom) > 1) {
                sb.append(map.get(atom));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        new _726_Number_of_Atoms().countOfAtoms("H2O");
    }
}
