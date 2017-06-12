class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums) < 1:
            return 0

        mp = {}
        for x in nums:
            if not mp.has_key(x):
                left = mp.get(x - 1, 0)
                right = mp.get(x + 1, 0)
                mp[x - left] = mp[x + right] = mp[x] = left + right + 1

        return max(mp.itervalues())