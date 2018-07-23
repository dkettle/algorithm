/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.practice.string;

/**
 * UniqueCharacter
 *
 * @author xuhaoran01
 */
public class UniqueCharacter {

    public boolean isUnique(String s) {
        int[] hits = new int[8];
        for (char c : s.toCharArray()) {
            int t = (int) c;
            int idx = t / 32, shift = t % 32;
            if ((hits[idx] & (1 << shift)) != 0) {
                return false;
            }

            hits[idx] |= (1 << shift);
        }

        return true;
    }

    public static void main(String[] args) {
        UniqueCharacter uc = new UniqueCharacter();
        System.out.println(uc.isUnique("abcdef"));
        System.out.println(uc.isUnique("abcdea"));
    }
}
