class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        val, cnt = 0, 0
        for num in nums:
            if cnt == 0:
                val, cnt = num, 1
            elif val == num:
                cnt += 1
            else:
                cnt -= 1

        return val
