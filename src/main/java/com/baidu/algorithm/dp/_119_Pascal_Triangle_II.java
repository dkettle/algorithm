/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * _119_Pascal_Triangle_II
 *
 * @author xuhaoran01
 */
public class _119_Pascal_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            for(int j = res.size() - 1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
            res.add(1);
        }

        return res;
    }
}
