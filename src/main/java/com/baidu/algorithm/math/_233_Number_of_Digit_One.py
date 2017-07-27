class Solution(object):
    def countDigitOne(self, n):
        """
        :type n: int
        :rtype: int
        """
        res, m = 0, 1
        while n >= m:
            a, b = divmod(n, m)

            c = a % 10
            a /= 10

            if c == 0:
                res += a * m
            elif c == 1:
                res += a * m + b + 1
            else:
                res += (a + 1) * m

            m *= 10

        return res
