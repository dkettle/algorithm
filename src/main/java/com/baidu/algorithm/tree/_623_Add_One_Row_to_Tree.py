# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


from collections import deque


class Solution(object):
    # iterative
    def addOneRow1(self, root, v, d):
        """
        :type root: TreeNode
        :type v: int
        :type d: int
        :rtype: TreeNode
        """
        if d == 1:
            node = TreeNode(v)
            node.left = root

            return node

        dq = deque([root])
        while d > 2:
            d -= 1
            next_dq = deque()
            while dq:
                node = dq.popleft()
                if node.left:
                    next_dq.append(node.left)
                if node.right:
                    next_dq.append(node.right)
            dq = next_dq

        while dq:
            node, left_node, right_node = dq.popleft(), TreeNode(v), TreeNode(v)

            left_node.left, right_node.right = node.left, node.right

            node.left, node.right = left_node, right_node

        return root

    # recursion
    def addOneRow(self, root, v, d):
        if d == 0 or d == 1:
            node = TreeNode(v)
            if d == 1:
                node.left = root
            else:
                node.right = root
            return node

        if root:
            root.left = self.addOneRow(root.left, v, d - 1 if d > 2 else 1)
            root.right = self.addOneRow(root.right, v, d - 1 if d > 2 else 0)

        return root
