class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        first_val, first_cnt = 0, 0
        second_val, second_cnt = 1, 0
        for num in nums:
            if first_val == num:
                first_cnt += 1
            elif second_val == num:
                second_cnt += 1
            elif first_cnt == 0:
                first_val, first_cnt = num, 1
            elif second_cnt == 0:
                second_val, second_cnt = num, 1
            else:
                first_cnt -= 1
                second_cnt -= 1

        return [x for x in [first_val, second_val] if nums.count(x) > len(nums) / 3]
