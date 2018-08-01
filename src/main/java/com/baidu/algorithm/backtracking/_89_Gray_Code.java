/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * _89_Gray_Code
 *
 * @author xuhaoran01
 */
public class _89_Gray_Code {

    public List<Integer> grayCode(int n) {

        List<Integer> res = new ArrayList<>();
        res.add(0);

        int shift = 1;
        for (int i = 0; i < n; i++) {
            int sz = res.size();
            for (int j = sz - 1; j >= 0; j--) {
                res.add(shift + res.get(j));
            }

            shift <<= 1;
        }

        return res;
    }
}
