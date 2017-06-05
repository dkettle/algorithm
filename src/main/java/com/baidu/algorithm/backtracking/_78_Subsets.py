class Solution(object):

    def dfs(self, res, one_res, nums, index):
        res.append(one_res[:])

        for i in range(index, len(nums)):
            one_res.append(nums[i])
            self.dfs(res, one_res, nums, i + 1)
            one_res.pop()

    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if nums is None or len(nums) == 0:
            return [[]]

        nums.sort()
        res = []

        self.dfs(res, [], nums, 0)

        return res