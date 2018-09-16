/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.linkedlist;

import com.baidu.algorithm.datastructure.ListNode;

import java.util.*;

/**
 * _817_Linked_List_Components
 *
 * @author xuhaoran01
 */
public class _817_Linked_List_Components {
    public int numComponents1(ListNode head, int[] G) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        ListNode prev = null;
        while (head != null) {
            map.put(head.val, new ArrayList<>());
            if (prev != null) {
                map.get(head.val).add(prev.val);
            }

            if (head.next != null) {
                map.get(head.val).add(head.next.val);
            }

            prev = head;
            head = head.next;
        }

        Map<Integer, Boolean> visited = new HashMap<>();
        for (int g : G) {
            visited.put(g, false);
        }

        int res = 0;
        for (int g : G) {
            if (!visited.get(g)) {
                dfs(visited, map, g);
                res++;
            }
        }

        return res;
    }

    private void dfs(Map<Integer, Boolean> visited, Map<Integer, List<Integer>> map, int num) {
        if (!visited.containsKey(num) || visited.get(num)) {
            return;
        }

        visited.put(num, true);
        for (int next : map.get(num)) {
            dfs(visited, map, next);
        }
    }

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }

        int res = 0;
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                res++;
            }

            head = head.next;
        }

        return res;
    }
}
