/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import sun.security.krb5.internal.ccache.CCacheInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _40_Combination_Sum_II
 *
 * @author xuhaoran01
 */
public class _40_Combination_Sum_II {

//    private void combinationSum2(List<List<Integer>> res, List<Integer> curRes, int[] candidates, int index, int tar) {
//
//        if (tar == 0) {
//            res.add(new ArrayList<>(curRes));
//        } else {
//            for (int i = index; i < candidates.length && candidates[i] <= tar; i++) {
//                if (i > index && candidates[i] == candidates[i - 1]) {
//                    continue;
//                }
//                curRes.add(candidates[i]);
//                combinationSum2(res, curRes, candidates, i + 1, tar - candidates[i]);
//                curRes.remove(curRes.size() - 1);
//            }
//        }
//    }
//
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//
//        Arrays.sort(candidates);
//
//        List<List<Integer>> res = new ArrayList<>();
//        combinationSum2(res, new ArrayList<Integer>(), candidates, 0, target);
//
//        return res;
//    }

    public static void main(String[] args) {
        new _40_Combination_Sum_II().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    private void combinationSum2(List<List<Integer>> res, List<Integer> curRes, int[] candidates, int index, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curRes));
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                curRes.add(candidates[i]);
                combinationSum2(res, curRes, candidates, i + 1, target - candidates[i]);
                curRes.remove(curRes.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        combinationSum2(res, new ArrayList<>(), candidates, 0, target);

        return res;
    }
}
