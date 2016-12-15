/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.hashtable;

/**
 * _299_Bulls_and_Cows
 *
 * @author xuhaoran01
 */
public class _299_Bulls_and_Cows {

    public String getHint(String secret, String guess) {

        int bull = 0, cows = 0;
        int[] count = new int[128];

        for (int i = 0; i < secret.length(); i++) {

            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                bull++;
            } else {
                if (count[c1]++ < 0) {
                    cows++;
                }
                if (count[c2]-- > 0) {
                    cows++;
                }
            }
        }

        return String.valueOf(bull) + "A" + String.valueOf(cows) + "B";
    }
}
