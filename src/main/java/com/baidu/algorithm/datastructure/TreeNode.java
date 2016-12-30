/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

import com.baidu.algorithm.annotation.Note;

/**
 * TreeNode
 *
 * @author xuhaoran01
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     *
     *
     (1)绑定。当equals方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。

     (2)绑定原因。Hashtable实现一个哈希表，为了成功地在哈希表中存储和检索对象，用作键的对象必须实现 hashCode 方法和 equals 方法。同(1)，必须保证equals相等的对象，hashCode 也相等。因为哈希表通过hashCode检索对象。

     (3)默认。

     　　==默认比较对象在JVM中的地址。

     　　hashCode 默认返回对象在JVM中的存储地址。

     　　equal比较对象，默认也是比较对象在JVM中的地址，同==
     *
     */
    public static void main(String[] args) {

        TreeNode node = new TreeNode(0);
        System.out.println(node.hashCode());
    }

    @Note(desc = "equals implementation")
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj instanceof TreeNode) {
            TreeNode node = (TreeNode) obj;
            if (node.val == val && node.hashCode() == hashCode()) {
                return true;
            }
        }

        return false;
    }

    public int hashCode() {

        return super.hashCode();
    }
}
