# Definition for a undirected graph node
class UndirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []


class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
        if not node:
            return None

        node_cy = UndirectedGraphNode(node.label)
        mp = {node: node_cy}
        stack = [node]

        while stack:
            cur_node = stack.pop()
            for neigh in cur_node.neighbors:
                if neigh not in mp:
                    node_cy = UndirectedGraphNode(neigh.label)
                    mp[neigh] = node_cy
                    stack.append(neigh)
                mp[cur_node].neighbors.append(mp[neigh])

        return mp[node]
