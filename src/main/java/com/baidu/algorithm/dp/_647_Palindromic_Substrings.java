/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

/**
 * _647_Palindromic_Substrings
 *
 * @author xuhaoran01
 */
public class _647_Palindromic_Substrings {
    // dp, O(N^2), O(N^2)
    public int countSubstrings1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int n = s.length(), res = 0;
        boolean[][] isPalindromic = new boolean[n][n];
        for (int k = 0; k < n; k++) {
            for (int i = 0; i + k < n; i++) {
                int j = i + k;
                if (s.charAt(i) == s.charAt(j) && (i + 1 > j - 1 || isPalindromic[i + 1][j - 1])) {
                    isPalindromic[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }

    // extend, O(N^2), O(1)
    public int countSubstrings2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int n = s.length(), res = 0;
        for (int i = 0; i <= 2 * n - 1; i++) {
            int left = i >> 1;
            int right = (i & 1) > 0 ? left + 1 : left;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }
        }

        return res;
    }

    //manacher, O(N), O(N)
    private char[] fillStr(String s) {
        int n = s.length();
        char[] res = new char[2 * n + 3];
        res[0] = '$';

        for (int i = 0; i < n; i++) {
            res[2 * i + 1] = '#';
            res[2 * i + 2] = s.charAt(i);
        }

        res[2 * n + 1] = '#';
        res[2 * n + 2] = '^';

        return res;
    }

    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        char[] chs = fillStr(s);

        int n = chs.length, idx = 0, right = 0;
        int[] dist = new int[n];

        for (int i = 1; i < n - 1; i++) {
            if (i < right) {
                dist[i] = Math.min(right - i, dist[2 * idx - i]);
            }

            while (chs[i + dist[i] + 1] == chs[i - dist[i] - 1]) {
                dist[i]++;
            }

            if (i + dist[i] > right) {
                idx = i;
                right = i + dist[i];
            }
        }

        int res = 0;
        for (int v : dist) {
            res += (v + 1) / 2;
        }

        return res;
    }
}
