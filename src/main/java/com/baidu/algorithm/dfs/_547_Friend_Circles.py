class Solution(object):
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        if not M or not M[0]:
            return 0

        n = len(M)
        uf = UnionFind(n)
        for i in xrange(n):
            for j in xrange(i + 1, n):
                if M[i][j]:
                    uf.union(i, j)

        return uf.num_of_class()


class UnionFind(object):
    def __init__(self, n):
        self.n = n
        self.father = range(n)
        self.rank = [1] * n

    def union(self, x, y):
        fx = self.find(x)
        fy = self.find(y)
        if fx != fy:
            if self.rank[fx] < self.rank[fy]:
                self.father[fx] = fy
            elif self.rank[fx] > self.rank[fy]:
                self.father[fy] = fx
            else:
                self.father[fy] = fx
                self.rank[fx] += 1

    def find(self, x):
        if x != self.father[x]:
            self.father[x] = self.find(self.father[x])

        return self.father[x]

    def num_of_class(self):
        father_set = set()
        for x in xrange(self.n):
            father_set.add(self.find(x))

        return len(father_set)


if __name__ == '__main__':
    s = Solution()
    s.findCircleNum([[1, 0, 0, 1], [0, 1, 1, 0], [0, 1, 1, 1], [1, 0, 1, 1]])
