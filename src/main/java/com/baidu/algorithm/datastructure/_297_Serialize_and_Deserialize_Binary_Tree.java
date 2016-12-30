/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * _297_Serialize_and_Deserialize_Binary_Tree
 *
 * @author xuhaoran01
 */
public class _297_Serialize_and_Deserialize_Binary_Tree {

    private class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            StringBuilder sb = new StringBuilder();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();

                if (cur == null) {
                    sb.append("null ");
                } else {
                    sb.append(cur.val).append(' ');
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }

            return sb.deleteCharAt(sb.length() - 1).toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            String[] vals = data.split(" ");

            TreeNode root = buildTreeNode(vals[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int i = 1;
            while (!queue.isEmpty() && i + 1 < vals.length) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    cur.left = buildTreeNode(vals[i]);
                    cur.right = buildTreeNode(vals[i + 1]);

                    queue.offer(cur.left);
                    queue.offer(cur.right);

                    i += 2;
                }
            }

            return root;
        }

        private TreeNode buildTreeNode(String str) {

            if ("null".equals(str)) {
                return null;
            } else {
                return new TreeNode(Integer.parseInt(str));
            }
        }
    }
}
