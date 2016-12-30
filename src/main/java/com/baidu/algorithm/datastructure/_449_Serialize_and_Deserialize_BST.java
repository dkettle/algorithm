/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.datastructure;

import java.util.Arrays;
import java.util.Stack;

import com.baidu.algorithm.annotation.Note;

/**
 * _449_Serialize_and_Deserialize_BST
 *
 * @author xuhaoran01
 */
public class _449_Serialize_and_Deserialize_BST {

    @Note(desc = "refer non static inner class in static method")
    public static void main(String[] args) {

//        TreeNode root = Utils.buildTree(1, 2, 3, -1, 4, -1, -1);

        TreeNode root = null;
        Codec codec = new _449_Serialize_and_Deserialize_BST().new Codec();
        String data = codec.serialize(root);
        codec.deserialize(data);
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            StringBuilder sb = new StringBuilder();

            Stack<TreeNode> st = new Stack<>();
            st.push(root);

            while (!st.isEmpty()) {
                TreeNode node = st.pop();
                if (node != null) {
                    sb.append(node.val).append(' ');
                    st.push(node.right);
                    st.push(node.left);
                }
            }

            return sb.length() == 0 ? sb.toString() : sb.deleteCharAt(sb.length() - 1).toString();
        }

        // Decodes your encoded data to tree.
        @Note(desc = "string array to int array")
        public TreeNode deserialize(String data) {

            // if data == "", vals have one element ""
            String[] vals = data.split(" ");
            if (vals.length == 0 || vals[0].length() == 0) {
                return null;
            }

            int[] intArr = Arrays.stream(vals).mapToInt(Integer::parseInt).toArray();

            return deserializeHelper(intArr, 0, vals.length - 1);
        }

        private TreeNode deserializeHelper(int[] vals, int start, int end) {

            if (start > end) {
                return null;
            }

            int index = start + 1;
            while (index <= end) {
                if (vals[start] < vals[index]) {
                    break;
                }
                index++;
            }

            TreeNode node = new TreeNode(vals[start]);
            node.left = deserializeHelper(vals, start + 1, index - 1);
            node.right = deserializeHelper(vals, index, end);

            return node;
        }
    }
}

