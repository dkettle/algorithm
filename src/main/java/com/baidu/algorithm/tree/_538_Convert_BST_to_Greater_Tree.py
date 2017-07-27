# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def __init__(self):
        self.cur_sum = 0

    def dfs(self, node):
        if not node:
            return

        self.dfs(node.right)
        node.val += self.cur_sum
        self.cur_sum = node.val
        self.dfs(node.left)

    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        self.dfs(root)
        return root
