class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if not nums or not k % len(nums):
            return

        n = len(nums)
        k %= n

        self.reverse_sublist(nums, 0, n - k)
        self.reverse_sublist(nums, n - k, n)
        self.reverse_sublist(nums, 0, n)

    @staticmethod
    def reverse_sublist(nums, begin, end):
        nums[begin:end] = nums[begin:end][::-1]
