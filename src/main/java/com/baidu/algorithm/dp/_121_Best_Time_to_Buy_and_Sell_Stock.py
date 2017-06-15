class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if prices is None or len(prices) < 2:
            return 0

        left_min, max_profit = prices[0], 0
        for i in range(1, len(prices)):
            max_profit = max(max_profit, prices[i] - left_min)
            left_min = min(left_min, prices[i])

        return max_profit
