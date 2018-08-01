/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * _71_Simplify_Path
 *
 * @author xuhaoran01
 */
public class _71_Simplify_Path {

    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return "";
        }

        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for (String dir : paths) {
            switch (dir) {
                case ".":
                    continue;
                case "":
                    continue;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(dir);
            }
        }

        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }

        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        new _71_Simplify_Path().simplifyPath("/..");
    }
}
