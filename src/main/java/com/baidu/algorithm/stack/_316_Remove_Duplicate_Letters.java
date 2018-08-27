/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.stack;

import java.util.Stack;

/**
 * _316_Remove_Duplicate_Letters
 *
 * @author xuhaoran01
 */
public class _316_Remove_Duplicate_Letters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int[] cnt = new int[26];
        boolean visited[] = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            cnt[idx]--;

            if (!visited[idx]) {
                while (!stack.isEmpty() && stack.peek() > c && cnt[stack.peek() - 'a'] > 0) {
                    visited[stack.pop() - 'a'] = false;
                }
                stack.push(c);
                visited[idx] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "acbacbacbacb";
        String s2 = "abab";
    }
}
