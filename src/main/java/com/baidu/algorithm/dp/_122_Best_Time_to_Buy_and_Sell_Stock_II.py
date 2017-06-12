class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if prices is None or len(prices) < 2:
            return 0

        max_profit = 0
        for i in range(1, len(prices)):
            max_profit += (prices[i] - prices[i - 1]) if  (prices[i] - prices[i - 1]) > 0 else 0

        return max_profit