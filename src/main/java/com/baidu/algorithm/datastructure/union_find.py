class UnionFind(object):
    def __init__(self, nums):
        self.father = {num: num for num in nums}
        self.rank = {num: 1 for num in nums}

    def union(self, x, y):
        father_x = self.find_father(x)
        father_y = self.find_father(y)
        if father_x != father_y:
            if self.rank[father_x] < self.rank[father_y]:
                self.father[father_x] = father_y
            else:
                self.father[father_y] = father_x
                if self.rank[father_x] == self.rank[father_y]:
                    self.rank[father_x] += 1

    def find_father(self, x):
        if self.father[x] != x:
            self.father[x] = self.find_father(self.father[x])
        return self.father[x]

    def is_same_father(self, x, y):
        return self.find_father(x) == self.find_father(y)


if __name__ == '__main__':
    uf = UnionFind([1, 2, 3, 4, 5, 6, 9, 11, 12])
    uf.union(1, 2)
    uf.union(1, 4)

    print uf.rank

    print uf.find_father(2)
    print uf.find_father(4)
    print uf.find_father(1)
    print uf.find_father(12)

    print uf.is_same_father(2, 4)
