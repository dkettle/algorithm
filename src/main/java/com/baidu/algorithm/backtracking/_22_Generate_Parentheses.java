/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * _22_Generate_Parentheses
 *
 * @author xuhaoran01
 */
public class _22_Generate_Parentheses {

    private void generateParenthesis(int left, int right, int n, List<String> res, StringBuilder sb) {

        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        else if (right > left) {
            return;
        }

        if (left < n) {
            sb.append('(');
            generateParenthesis(left + 1, right, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < n) {
            sb.append(')');
            generateParenthesis(left, right + 1, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        StringBuilder sb = new StringBuilder();
        generateParenthesis(0, 0, n, res, sb);

        return res;
    }
}
