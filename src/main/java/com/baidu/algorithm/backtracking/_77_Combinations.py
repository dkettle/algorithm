def dfs(res, oneRes, n, k):
    if len(oneRes) == k:
        res.append(oneRes[:])
    elif n > 0:
        dfs(res, oneRes, n - 1, k)

        oneRes.append(n)
        dfs(res, oneRes, n - 1, k)
        oneRes.pop()


def combine(n, k):
    """
    :type n: int
    :type k: int
    :rtype: List[List[int]]
    """
    res = []
    if n >= k:
        dfs(res, [], n, k)

    return res


##########
from itertools import combinations


def combine2(self, n, k):
    return list(combinations(range(1, n + 1), k))



if __name__ == '__main__':
    print combine(4, 2)
