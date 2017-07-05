from collections import deque

class Solution(object):
    # 拓扑排序
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        if numCourses < 2:
            return True

        in_degree = [0] * numCourses
        adj = [[] for _ in xrange(numCourses)]

        for x, y in prerequisites:
            in_degree[x] += 1
            adj[y].append(x)

        dq = deque()
        for x in xrange(numCourses):
            if not in_degree[x]:
                dq.append(x)

        cnt = 0
        while dq:
            x = dq.popleft()
            cnt += 1
            for i in adj[x]:
                in_degree[i] -= 1
                if in_degree[i] == 0:
                    dq.append(i)

        return cnt == numCourses
