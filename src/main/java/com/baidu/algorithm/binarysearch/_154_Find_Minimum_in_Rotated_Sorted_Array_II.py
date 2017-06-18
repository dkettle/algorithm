class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0

        begin, end = 0, len(nums) - 1
        while begin < end:
            mid = (begin + end) >> 1
            if nums[mid] == nums[end]:
                end -= 1
            elif nums[mid] > nums[end]:
                begin = mid + 1
            else:
                end = mid

        return nums[begin]
