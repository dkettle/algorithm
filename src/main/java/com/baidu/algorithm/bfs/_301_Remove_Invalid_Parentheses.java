/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.*;

/**
 * _301_Remove_Invalid_Parentheses
 *
 * @author xuhaoran01
 */
public class _301_Remove_Invalid_Parentheses {
    private boolean isValid(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
            }

            if (cnt < 0) {
                return false;
            }
        }

        return cnt == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String cur = queue.remove();
                if (!visited.contains(cur)) {
                    visited.add(cur);

                    if (isValid(cur)) {
                        found = true;
                        res.add(cur);
                    } else {
                        for (int j = 0; j < cur.length(); j++) {
                            if (cur.charAt(j) == '(' || cur.charAt(j) == ')') {
                                queue.add(cur.substring(0, j) + cur.substring(j + 1));
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new _301_Remove_Invalid_Parentheses().removeInvalidParentheses("()())()");
    }
}
