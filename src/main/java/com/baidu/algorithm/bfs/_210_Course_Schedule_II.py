class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        in_degree = [0] * numCourses
        adj = [[] for _ in xrange(numCourses)]

        for x, y in prerequisites:
            in_degree[x] += 1
            adj[y].append(x)

        stack = []
        for x in xrange(numCourses):
            if in_degree[x] == 0:
                stack.append(x)

        res, count = [], 0
        while stack:
            x = stack.pop()
            count += 1
            res.append(x)

            for y in adj[x]:
                in_degree[y] -= 1
                if in_degree[y] == 0:
                    stack.append(y)

        return [] if count < numCourses else res
