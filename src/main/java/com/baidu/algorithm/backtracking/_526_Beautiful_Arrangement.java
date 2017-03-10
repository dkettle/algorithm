/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * _526_Beautiful_Arrangement
 *
 * @author xuhaoran01
 */
public class _526_Beautiful_Arrangement {

    int count = 0;

    private void dfs(List<Integer> nums, int index) {

        if (nums.size() == 0) {
            count++;
        }

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num % index == 0 || index % num == 0) {
                nums.remove(i);
                dfs(nums, index + 1);
                nums.add(i, num);
            }
        }
    }

    public int countArrangement(int N) {

        List<Integer> nums = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            nums.add(i);
        }

        dfs(nums, 1);

        return count;
    }
}
