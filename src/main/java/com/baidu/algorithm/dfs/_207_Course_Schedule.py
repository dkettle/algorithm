class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """

        if numCourses < 2:
            return True

        graph = [[] for _ in xrange(numCourses)]
        for x, y in prerequisites:
            graph[y].append(x)

        visited = [False] * numCourses
        for i in xrange(numCourses):
            if not self.dfs(graph, visited, i):
                return False

        return True

    def dfs(self, graph, visited, i):
        if visited[i]:
            return False

        visited[i] = True
        for x in graph[i]:
            if not self.dfs(graph, visited, x):
                return False

        visited[i] = False

        return True


if __name__ == '__main__':
    s = Solution()
    s.canFinish(2, [[1, 0]])
