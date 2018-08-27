/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * _679_24_Game
 *
 * @author xuhaoran01
 */
public class _679_24_Game {

    public boolean judgePoint24(int[] nums) {
        if (nums == null || nums.length != 4) {
            return false;
        }

        List<Double> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add((double) num);
        }

        return dfs(arr);
    }

    private boolean dfs(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-5;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) {
                    continue;
                }

                List<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        next.add(nums.get(k));
                    }
                }

                for (int k = 0; k < 4; k++) {
                    switch (k) {
                        case 0:
                            next.add(nums.get(i) + nums.get(j));
                            break;
                        case 1:
                            next.add(nums.get(i) - nums.get(j));
                            break;
                        case 2:
                            next.add(nums.get(i) * nums.get(j));
                            break;
                        case 3:
                            if (nums.get(j) != 0) {
                                next.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                            break;
                    }

                    if (dfs(next)) {
                        return true;
                    }
                    next.remove(next.size() - 1);
                }
            }
        }

        return false;
    }
}
