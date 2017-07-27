class Solution(object):
    def arrayNesting(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res, n = 0, len(nums)

        visited = [False] * n
        for x in nums:
            cnt = 0
            while not visited[x]:
                visited[x] = True
                cnt += 1
                x = nums[x]
            res = max(res, cnt)

        return res
