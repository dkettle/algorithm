/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * _118_Pascal_Triangle
 *
 * @author xuhaoran01
 */
public class _118_Pascal_Triangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curRes = new ArrayList<>();

        for(int i = 1; i <= numRows; i++) {
            for(int j = curRes.size() - 1; j > 0; j--) {
                curRes.set(j, curRes.get(j) + curRes.get(j - 1));
            }
            curRes.add(1);
            res.add(new ArrayList<>(curRes));
        }

        return res;
    }
}
