class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # local maximum
        if not nums:
            return 0

        begin, end = 0, len(nums) - 1
        while begin < end:
            if begin + 1 == end:
                return begin if nums[begin] > nums[end] else end

            mid = (begin + end) >> 1
            if nums[mid - 1] < nums[mid] > nums[mid + 1]:
                return mid
            elif nums[mid - 1] < nums[mid] < nums[mid + 1]:
                begin = mid + 1
            else:
                end = mid - 1

        return begin


if __name__ == '__main__':
    s = Solution()
    s.findPeakElement([1, 2, 3, 1])
