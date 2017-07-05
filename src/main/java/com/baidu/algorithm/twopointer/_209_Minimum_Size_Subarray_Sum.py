class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        res = n + 1

        i, cur = 0, 0
        for j in xrange(n):
            cur += nums[j]
            if cur >= s:
                while cur >= s:
                    cur -= nums[i]
                    i += 1
                res = min(res, j - i + 2)

        return 0 if res == n + 1 else res


if __name__ == '__main__':
    s = Solution()
    s.minSubArrayLen(7, [2, 3, 1, 2, 4, 3])
