from collections import deque


class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        if not root:
            return []

        res = []
        node_dq = deque()
        sum_val, sum_cnt = 0, 0

        node_dq.append(root)
        node_dq.append(None)

        while node_dq:
            node = node_dq.popleft()

            if node:
                if node.left:
                    node_dq.append(node.left)
                if node.right:
                    node_dq.append(node.right)
                sum_val += node.val
                sum_cnt += 1
            else:
                if sum_cnt > 0:
                    res.append(sum_val / float(sum_cnt))
                    sum_val, sum_cnt = 0, 0
                    node_dq.append(None)

        return res

    '''
        dfs
    '''

    def averageOfLevels1(self, root):

        self.level_info = []
        self.dfs(root, 0)

        return [float(x) / y for x, y in self.level_info]

    def dfs(self, root, depth):
        if root:
            if len(self.level_info) <= depth:
                self.level_info.append([0, 0])

            self.level_info[depth][0] += root.val
            self.level_info[depth][1] += 1

            self.dfs(root.left, depth + 1)
            self.dfs(root.right, depth + 1)
