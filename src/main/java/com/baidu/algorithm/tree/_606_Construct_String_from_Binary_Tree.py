# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def tree2str(self, t):
        """
        :type t: TreeNode
        :rtype: str
        """
        if not t:
            return ''
        return self.dfs(t)

    def dfs(self, node):
        # left null & right null
        if not node.left and not node.right:
            return repr(node.val)
        # left null
        if not node.left:
            return repr(node.val) + '()' + '(' + self.dfs(node.right) + ')'
        # right null
        if not node.right:
            return repr(node.val) + '(' + self.dfs(node.left) + ')'

        return repr(node.val) + '(' + self.dfs(node.left) + ')' + '(' + self.dfs(node.right) + ')'
