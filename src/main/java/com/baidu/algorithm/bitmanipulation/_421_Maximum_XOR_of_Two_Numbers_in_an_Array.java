/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bitmanipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * _421_Maximum_XOR_of_Two_Numbers_in_an_Array
 *
 * @author xuhaoran01
 */
public class _421_Maximum_XOR_of_Two_Numbers_in_an_Array {

    public int findMaximumXOR1(int[] nums) {
        int mx = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            int t = mx | (1 << i);
            for (int num : set) {
                // A ^ B = C   -> A = B ^ C
                // n1 ^ n2 = t -> set.contains(t ^ n1)
                if (set.contains(t ^ num)) {
                    mx = t;
                    break;
                }
            }
        }

        return mx;
    }


    //
    class TrieNode {
        public TrieNode[] child;

        public TrieNode() {
            child = new TrieNode[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int b = (num >> i) & 1;
                if (cur.child[b] == null) {
                    cur.child[b] = new TrieNode();
                }

                cur = cur.child[b];
            }
        }

        int mx = 0;
        for (int num : nums) {
            int curMx = 0;
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int b = (num >> i) & 1;
                if (cur.child[b ^ 1] != null) {
                    curMx += 1 << i;
                    cur = cur.child[b ^ 1];
                } else {
                    cur = cur.child[b];
                }
            }

            mx = Math.max(mx, curMx);
        }

        return mx;
    }
}
