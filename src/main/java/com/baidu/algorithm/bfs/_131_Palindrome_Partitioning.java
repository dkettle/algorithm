/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * _131_Palindrome_Partitioning
 *
 * @author xuhaoran01
 */
public class _131_Palindrome_Partitioning {

    private boolean isPalindrome(String s) {

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    private void dfs(List<List<String>> res, List<String> curRes, String s) {
        if (s.isEmpty()) {
            res.add(new ArrayList<>(curRes));
        } else {
            for (int i = 1; i <= s.length(); i++) {
                if (isPalindrome(s.substring(0, i))) {
                    curRes.add(s.substring(0, i));
                    dfs(res, curRes, s.substring(i));
                    curRes.remove(curRes.size() - 1);
                }
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }

        dfs(res, new ArrayList<>(), s);

        return res;
    }
}
