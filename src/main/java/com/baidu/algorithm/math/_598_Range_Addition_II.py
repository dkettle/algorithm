class Solution(object):
    def maxCount(self, m, n, ops):
        """
        :type m: int
        :type n: int
        :type ops: List[List[int]]
        :rtype: int
        """
        min_a, min_b = m, n
        for pair in ops:
            min_a = min(min_a, pair[0])
            min_b = min(min_b, pair[1])

        return min_a * min_b
