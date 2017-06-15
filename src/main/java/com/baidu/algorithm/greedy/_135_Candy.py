class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        if not ratings:
            return 0

        n = len(ratings)
        num = [1] * n

        for i in xrange(1, n):
            if ratings[i] > ratings[i - 1]:
                num[i] = num[i - 1] + 1

        for i in xrange(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                num[i] = max(num[i], num[i + 1] + 1)

        return sum(num)
