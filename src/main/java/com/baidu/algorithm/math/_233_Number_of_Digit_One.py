class Solution(object):
    def countDigitOne(self, n):
        """
        :type n: int
        :rtype: int
        """
        res, m = 0, 1
        while n >= m:
            a, b = divmod(n, m)

            res += (a + 8) / 10 * m + (a % 10 == 1) * (b + 1)

            m *= 10

        return res
