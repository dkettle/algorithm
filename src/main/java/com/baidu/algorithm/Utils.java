/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * Utils
 *
 * @author xuhaoran01
 */
public class Utils {

    // Collections.swap
    //
    public static void swap(List<Integer> list, int i, int j) throws IndexOutOfBoundsException {

        if (list == null || list.isEmpty() || i == j) {
            return;
        }

        if (i >= list.size() || j >= list.size()) {
            throw new IndexOutOfBoundsException("swap index out of list size");
        }

        int tmp = list.get(i);

        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public static void swap(Object[] arr, int i, int j) throws IndexOutOfBoundsException {

        if (arr == null || arr.length == 0) {
            return;
        }

        Object o = arr[i];
        arr[i] = arr[j];
        arr[j] = o;
    }

    public static void swap(char[] arr, int i, int j) throws IndexOutOfBoundsException {

        if (arr == null || arr.length == 0) {
            return;
        }

        char o = arr[i];
        arr[i] = arr[j];
        arr[j] = o;
    }

    // Collections.shuffle
    //
    public static void shuffle(List<Integer> nums) {

        if (nums == null || nums.size() == 0) {
            return;
        }

        Random rand = new Random();

        for (int i = nums.size(); i > 1; i--) {
            int index = rand.nextInt(i);

            Utils.swap(nums, i - 1, index);
        }
    }

    public static ListNode buildListNode(int... nums) {

        ListNode dummy = new ListNode(0), head = dummy;
        for (int v : nums) {
            head.next = new ListNode(v);
            head = head.next;
        }

        return dummy.next;
    }

    // -1 represents null
    public static TreeNode buildTree(int... num) {

        TreeNode root = buildTreeNode(num[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i + 1 < num.length) {
            TreeNode cur = queue.poll();
            cur.left = buildTreeNode(num[i]);
            cur.right = buildTreeNode(num[i + 1]);

            queue.offer(cur.left);
            queue.offer(cur.right);
            i += 2;
        }

        return root;
    }

    private static TreeNode buildTreeNode(int v) {

        return v == -1 ? null : new TreeNode(v);
    }
}
