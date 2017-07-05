from collections import deque


class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        dq = deque()
        res = []
        for i, num in enumerate(nums):
            if dq and dq[0] == i - k:
                dq.popleft()

            while dq and nums[dq[-1]] <= num:
                dq.pop()

            dq.append(i)
            if i >= k - 1:
                res.append(nums[dq[0]])

        return res
