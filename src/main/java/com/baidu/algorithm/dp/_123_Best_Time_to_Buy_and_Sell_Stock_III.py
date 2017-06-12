class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if prices is None or len(prices) < 2:
            return 0

        left_min, right_max = prices[0], prices[-1]
        left_profit, right_profit = [0], [0]

        for i in range(1, len(prices)):
            left_profit.append(max(left_profit[-1], prices[i] - left_min))
            left_min = min(left_min, prices[i])

        for i in range(len(prices) - 2, -1, -1):
            right_profit.append(max(right_profit[-1], right_max - prices[i]))
            right_max = max(right_max, prices[i])

        right_profit.reverse()

        max_profit = [x + y for x, y in zip(left_profit, right_profit)]

        return max(max_profit)