class Solution(object):
    def distributeCandies(self, candies):
        """
        :type candies: List[int]
        :rtype: int
        """
        candy_kinds, candy_num = len(set(candies)), len(candies)
        return min(candy_kinds, candy_num / 2)
