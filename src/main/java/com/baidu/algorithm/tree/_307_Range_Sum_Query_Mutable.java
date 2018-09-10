/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.tree;

/**
 * _307_Range_Sum_Query_Mutable
 *
 * @author xuhaoran01
 */
public class _307_Range_Sum_Query_Mutable {

    class NumArray {

        private SegmentTree tree;

        public NumArray(int[] nums) {
            tree = new SegmentTree(nums);
        }

        public void update(int i, int val) {
            tree.update(i, val);
        }

        public int sumRange(int i, int j) {
            return tree.query(i, j);
        }
    }

    class SegmentTree {
        private int n;
        private int[] tree;

        public SegmentTree(int[] nums) {
            n = nums.length;
            tree = new int[n << 2];

            buildTree(0, n - 1, 1, nums);
        }

        private void buildTree(int l, int r, int pos, int[] num) {
            if (l > r) {
                return;
            } else if (l == r) {
                tree[pos] = num[l];
                return;
            }

            int m = (l + r) >> 1;
            buildTree(l, m, pos << 1, num);
            buildTree(m + 1, r, (pos << 1) | 1, num);

            tree[pos] = tree[pos << 1] + tree[(pos << 1) | 1];
        }

        public void update(int i, int v) {
            update(i, v, 0, n - 1, 1);
        }

        private void update(int i, int v, int l, int r, int pos) {
            if (l == r) {
                tree[pos] = v;
                return;
            }

            int m = (l + r) >> 1;
            if (i <= m) {
                update(i, v, l, m, pos << 1);
            } else {
                update(i, v, m + 1, r, (pos << 1) | 1);
            }

            tree[pos] = tree[pos << 1] + tree[(pos << 1) | 1];
        }

        public int query(int l, int r) {
            return query(l, r, 0, n - 1, 1);
        }

        private int query(int ql, int qr, int l, int r, int pos) {
            if (ql <= l && r <= qr) {
                return tree[pos];
            }

            int res = 0, m = (l + r) >> 1;
            if (ql <= m) {
                res += query(ql, qr, l, m, pos << 1);
            }

            if (qr > m) {
                res += query(ql, qr, m + 1, r, (pos << 1) | 1);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new _307_Range_Sum_Query_Mutable().new NumArray(new int[]{1, 3, 5});
        numArray.sumRange(0, 2);
        numArray.update(1, 2);
        numArray.sumRange(0, 2);
    }
}
