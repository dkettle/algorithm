class Solution(object):
    def findComplement(self, num):
        """
        :type num: int
        :rtype: int
        """

        res, pos = 0, 0
        while num:
            bit = num & 1
            res |= (1 - bit) << pos
            pos += 1
            num >>= 1

        return res
