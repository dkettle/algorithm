class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        xor_val = 0
        for x in nums:
            xor_val ^= x

        bit_pos = 1
        while not (xor_val & bit_pos):
            bit_pos <<= 1

        v1, v2 = 0, 0
        for x in nums:
            if x & bit_pos:
                v1 ^= x
            else:
                v2 ^= x

        return [v1, v2]
