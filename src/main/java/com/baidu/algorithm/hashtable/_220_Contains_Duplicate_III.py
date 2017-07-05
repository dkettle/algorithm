class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        if t < 0:
            return False

        d = {}
        w = t + 1

        for i in xrange(len(nums)):
            key = nums[i] / w
            if key in d:
                return True
            if key - 1 in d and abs(nums[i] - d.get(key - 1)) < w:
                return True
            if key + 1 in d and abs(nums[i] - d.get(key + 1)) < w:
                return True
            d[key] = nums[i]

            if i >= k:
                del d[nums[i - k] / w]

        return False
