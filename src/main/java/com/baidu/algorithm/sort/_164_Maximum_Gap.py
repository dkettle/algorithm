class Solution(object):
    def maximumGap(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums) < 2:
            return 0

        max_val, min_val, n = max(nums), min(nums), len(nums)

        if max_val == min_val:
            return 0

        left, right = [-1] * n, [-1] * n
        gap = float(max_val - min_val) / (n - 1)

        for num in nums:
            bucket = int((num - min_val) / gap)
            if left[bucket] == -1:
                left[bucket] = right[bucket] = num
            else:
                left[bucket] = min(left[bucket], num)
                right[bucket] = max(right[bucket], num)

        res, cur = 0, right[0]
        for x, y in zip(left[1:], right[1:]):
            if x != -1:
                res = max(res, x - cur)
                cur = y

        return res
