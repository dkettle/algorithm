/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * _217_Contains_Duplicate
 *
 * @author xuhaoran01
 */
public class _217_Contains_Duplicate {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int v : nums) {
            if (set.contains(v)) {
                return true;
            }

            set.add(v);
        }

        return false;
    }
}
