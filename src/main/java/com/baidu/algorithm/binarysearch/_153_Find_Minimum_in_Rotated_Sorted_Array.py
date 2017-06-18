class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0

        start, end = 0, len(nums) - 1
        while start < end:
            mid = (start + end) >> 1
            if nums[mid] > nums[end]:
                start = mid + 1
            else:
                end = mid

        return nums[start]
