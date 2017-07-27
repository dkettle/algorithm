import sys


class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [sys.maxint] * (n + 1)
        dp[0] = 0

        for i in xrange(1, n + 1):
            j = 1
            while j ** 2 <= i:
                dp[i] = min(dp[i], dp[i - j * j] + 1)
                j += 1

        return dp[n]


if __name__ == '__main__':
    s = Solution()
    s.numSquares(1)
