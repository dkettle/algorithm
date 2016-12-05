/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.string;

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

        if (path == null || path.length() == 0) {
            return "";
        }

        Deque<String> deque = new LinkedList<>();
        String[] paths = path.split("/");

        for (String dir : paths) {
            if (dir.length() > 0) {
                if (dir.equals("..")) {
                    if (!deque.isEmpty()) {
                        deque.pop();
                    }
                }
                else if (dir.equals(".")) {
                    continue;
                }
                else {
                    deque.push(dir);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pollLast());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        new _71_Simplify_Path().simplifyPath("/..");
    }
}
