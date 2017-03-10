/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * _13_Roman_to_Integer
 *
 * @author xuhaoran01
 */
public class _13_Roman_to_Integer {

    public int romanToInt(String s) {

        int[] values = {1000,500,100,50,10,5,1};
        char[] strs = {'M','D', 'C','L','X','V','I'};

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(strs[i], values[i]);
        }

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= val;
            }
            else {
                res += val;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        new _13_Roman_to_Integer().romanToInt("MMMDLXXXVI");
    }
}
