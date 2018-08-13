/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * _315_Count_of_Smaller_Numbers_After_Self
 *
 * @author xuhaoran01
 */
public class _315_Count_of_Smaller_Numbers_After_Self {

    class Node {
        int val;
        int count;
        Node left, right;

        public Node(int v, int c) {
            val = v;
            count = c;
        }
    }

    private int insertNode(Node root, int v) {
        int curNum = 0;
        while (root != null) {
            if (v <= root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = new Node(v, 1);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                curNum += root.count;
                if (root.right == null) {
                    root.right = new Node(v, 1);
                    break;
                } else {
                    root = root.right;
                }
            }
        }

        return curNum;
    }

    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Node root = new Node(nums[nums.length - 1], 1);
        res.add(0);

        for (int i = nums.length - 2; i >= 0; i--) {
            res.add(insertNode(root, nums[i]));
        }

        Collections.reverse(res);

        return res;
    }

    // mergeSort method

    private int[] count;

    private void mergeSort(int[] nums, int[] index, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int mid = (begin + end) / 2;
        mergeSort(nums, index, begin, mid);
        mergeSort(nums, index, mid + 1, end);

        int[] newIndex = new int[end - begin + 1];
        int lEnd = mid, rEnd = end, mEnd = end - begin;
        while (lEnd >= begin && rEnd > mid) {
            if (nums[index[rEnd]] >= nums[index[lEnd]]) {
                newIndex[mEnd--] = index[rEnd--];
            } else {
                newIndex[mEnd--] = index[lEnd];
                count[index[lEnd]] += rEnd - mid;
                lEnd--;
            }
        }

        while (lEnd >= begin) {
            newIndex[mEnd--] = index[lEnd--];
        }

        while (rEnd > mid) {
            newIndex[mEnd--] = index[rEnd--];
        }

        for (int i = begin; i <= end; i++) {
            index[i] = newIndex[i - begin];
        }
    }


    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        count = new int[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        mergeSort(nums, index, 0, nums.length - 1);
        for (int v : count) {
            res.add(v);
        }

        return res;
    }

    public static void main(String[] args) {
        new _315_Count_of_Smaller_Numbers_After_Self().countSmaller(new int[]{5, 2, 6, 1});
    }
}
