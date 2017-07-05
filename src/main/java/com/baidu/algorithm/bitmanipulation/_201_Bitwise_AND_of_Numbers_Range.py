class Solution(object):
    def rangeBitwiseAnd(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        factor = 1
        while m != n:
            factor <<= 1
            m >>= 1
            n >>= 1

        return m * factor
