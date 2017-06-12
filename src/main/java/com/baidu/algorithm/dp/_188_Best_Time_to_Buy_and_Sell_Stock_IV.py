class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int

        dp[i, j] represents the max profit up until prices[j] using at most i transactions.
        dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
                 = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
        dp[0, j] = 0; 0 transactions makes 0 profit
        dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
        """
        if prices is None or len(prices) < 2:
            return 0

        n = len(prices)
        if k >= n / 2:
            return sum(i - j for i, j in zip(prices[1:], prices[:-1]) if i > j)

        dp = [[0] * n for _ in xrange(k + 1)]
        for i in xrange(1, k + 1):
            tmp_max = -prices[0]
            for j in xrange(1, n):
                dp[i][j] = max(dp[i][j - 1], prices[j] + tmp_max)
                tmp_max = max(tmp_max, dp[i - 1][j] - prices[j])

        return dp[-1][-1]
