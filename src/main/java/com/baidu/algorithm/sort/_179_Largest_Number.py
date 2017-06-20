class Solution:
    # @param {integer[]} nums
    # @return {string}
    def largestNumber(self, nums):
        if not nums:
            return ""

        nums = [str(num) for num in nums]
        nums.sort(cmp=lambda x, y: cmp(x + y, y + x), reverse=True)

        return "".join(nums).lstrip('0') or '0'
