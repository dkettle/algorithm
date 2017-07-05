class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        if not nums:
            return []

        res = []
        i, n = 0, len(nums)
        for j in xrange(1, n):
            if nums[j] - nums[i] != j - i:
                res.append(str(nums[i]) if j == i + 1 else (str(nums[i]) + '->' + str(nums[j - 1])))
                i = j

        if i == n - 1:
            res.append(str(nums[-1]))
        else:
            res.append(str(nums[i]) + '->' + str(nums[-1]))

        return res
