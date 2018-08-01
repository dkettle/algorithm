/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.bfs;

import java.util.*;

/**
 * _133_Clone_Graph
 *
 * @author xuhaoran01
 */
public class _133_Clone_Graph {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> mp = new HashMap<>();
        UndirectedGraphNode nodeDup = new UndirectedGraphNode(node.label);
        mp.put(node, nodeDup);

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.remove();
            UndirectedGraphNode curDup = mp.get(cur);

            for (UndirectedGraphNode neigh : cur.neighbors) {
                if (!mp.containsKey(neigh)) {
                    queue.add(neigh);
                    UndirectedGraphNode neighDup = new UndirectedGraphNode(neigh.label);
                    mp.put(neigh, neighDup);
                }

                curDup.neighbors.add(mp.get(neigh));
            }
        }

        return mp.get(node);
    }
}
