class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return

        i, j, n = 0, 0, len(nums)
        while j < n:
            if nums[j] != 0:
                nums[i] = nums[j]
                i += 1
            j += 1

        while i < n:
            nums[i] = 0
            i += 1
