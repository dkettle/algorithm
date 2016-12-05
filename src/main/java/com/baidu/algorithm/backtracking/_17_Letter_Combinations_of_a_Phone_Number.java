/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * _17_Letter_Combinations_of_a_Phone_Number
 *
 * @author xuhaoran01
 */
public class _17_Letter_Combinations_of_a_Phone_Number {

    private static String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void letterCombinations(String digits, int index, List<String> res, String str) {
        if (index == digits.length()) {
            res.add(str);
            return;
        }

        int idx = Integer.parseInt(String.valueOf(digits.charAt(index)));
        String letter = letters[idx - 2];

        for (char ch : letter.toCharArray()) {
            letterCombinations(digits, index + 1, res, str + ch);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        letterCombinations(digits, 0, res, "");

        return res;
    }
}
