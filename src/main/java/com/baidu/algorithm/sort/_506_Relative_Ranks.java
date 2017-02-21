/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.sort;

import java.util.Arrays;

/**
 * _506_Relative_Ranks
 *
 * @author xuhaoran01
 */
public class _506_Relative_Ranks {

    public String[] findRelativeRanks(int[] nums) {

        int n = nums.length;
        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (x, y) -> (nums[y] - nums[x]));
        
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[index[i]] = "Gold Medal";
            }
            else if (i == 1) {
                res[index[i]] = "Silver Medal";
            }
            else if (i == 2) {
                res[index[i]] = "Bronze Medal";
            }
            else {
                res[index[i]] = String.valueOf(i + 1);
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        new _506_Relative_Ranks().findRelativeRanks(new int[]{10, 3, 8, 9, 4});
    }
}
