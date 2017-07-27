class Solution(object):
    def getSum(self, a, b):
        """
        :type a: int
        :type b: int
        :rtype: int
        """
        int_min = 0x80000000
        int_max = 0x7FFFFFFF
        mask = 0xFFFFFFFF

        while b != 0:
            a, b = (a ^ b) & mask, ((a & b) << 1) & mask

        return a if a <= int_max else ~(a ^ mask)


if __name__ == '__main__':
    s = Solution()
    print s.getSum(-12, -8)
