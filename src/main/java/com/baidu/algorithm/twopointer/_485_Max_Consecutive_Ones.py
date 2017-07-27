class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i, res = 0, 0
        for j, y in enumerate(nums):
            if y != 1:
                res = max(res, j - i)
                i = j + 1

        return max(res, len(nums) - i)
