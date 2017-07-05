class Solution(object):
    # direct sort
    def findKthLargest1(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        return sorted(nums, reverse=True)[k - 1]

    # bubble sort
    def findKthLargest2(self, nums, k):
        n = len(nums)
        for i in xrange(k):
            for j in xrange(n - i - 1):
                if nums[j] > nums[j + 1]:
                    nums[j], nums[j + 1] = nums[j + 1], nums[j]

        return nums[n - k]

    def findKthLargest(self, nums, k):
        import heapq
        return heapq.nlargest(k, nums)[k - 1]
