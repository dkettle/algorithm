/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _40_Combination_Sum_II
 *
 * @author xuhaoran01
 */
public class _40_Combination_Sum_II {

    private void combinationSum2(List<List<Integer>> res, List<Integer> curRes, int[] candidates, int index, int tar) {

        if (tar == 0) {
            res.add(new ArrayList<>(curRes));
        }
        else {
            for (int i = index; i < candidates.length && candidates[i] <= tar; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                curRes.add(candidates[i]);
                combinationSum2(res, curRes, candidates, i + 1, tar - candidates[i]);
                curRes.remove(curRes.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        combinationSum2(res, new ArrayList<Integer>(), candidates, 0, target);

        return res;
    }
}
