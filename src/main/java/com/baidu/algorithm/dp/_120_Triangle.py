class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if triangle is None:
            return 0

        dp = [triangle[0][0]]
        for i in range(1, len(triangle)):
            dp.append(dp[-1] + triangle[i][-1])
            for j in range(len(triangle[i]) - 2, 0, -1):
                dp[j] = min(dp[j - 1], dp[j]) + triangle[i][j]
            dp[0] += triangle[i][0]

        return min(dp)


