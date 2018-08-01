/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _39_Combination_Sum
 *
 * @author xuhaoran01
 */
public class _39_Combination_Sum {

//    private void combinationSum(List<List<Integer>> res, List<Integer> curRes, int[] candidates, int index,
//                                int target) {
//
//        if (target == 0) {
//            res.add(new ArrayList<>(curRes));
//        } else {
//            for (int i = index; i < candidates.length; i++) {
//                if (candidates[i] <= target) {
//                    curRes.add(candidates[i]);
//                    combinationSum(res, curRes, candidates, i, target - candidates[i]);
//                    curRes.remove(curRes.size() - 1);
//                }
//            }
//        }
//    }
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        List<List<Integer>> res = new ArrayList<>();
//
//        combinationSum(res, new ArrayList<>(), candidates, 0, target);
//
//        return res;
//    }

    public static void main(String[] args) {
        new _39_Combination_Sum().combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    private void combinationSum(List<List<Integer>> res, List<Integer> curRes, int[] candidates, int pos, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curRes));
        } else if (target > 0) {
            for (int i = pos; i < candidates.length; i++) {
                curRes.add(candidates[i]);

                combinationSum(res, curRes, candidates, i, target - candidates[i]);

                curRes.remove(curRes.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        combinationSum(res, new ArrayList<>(), candidates, 0, target);

        return res;
    }
}
