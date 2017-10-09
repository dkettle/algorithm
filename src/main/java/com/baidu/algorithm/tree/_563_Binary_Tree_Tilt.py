# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def __init__(self):
        self.tilt = 0

    def calc_sum(self, root):
        if not root:
            return 0

        l_val = self.calc_sum(root.left)
        r_val = self.calc_sum(root.right)

        self.tilt += abs(l_val - r_val)

        return l_val + root.val + r_val

    def findTilt(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.calc_sum(root)

        return self.tilt
