class Solution(object):
    def singleNonDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        left, right = 0, n / 2
        while left < right:
            m = (left + right) >> 1
            if nums[2 * m] == nums[2 * m + 1]:
                left = m + 1
            else:
                right = m

        return nums[2 * left]
