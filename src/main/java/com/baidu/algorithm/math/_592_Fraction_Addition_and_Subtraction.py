from fractions import Fraction
import re


class Solution(object):
    def fractionAddition(self, expression):
        """
        :type expression: str
        :rtype: str
        """
        res = sum(map(Fraction, expression.replace('+', ' +').replace('-', ' -').split()))

        return "{}/{}".format(res.numerator, res.denominator)

    def fractionAddition1(self, expression):
        nums = map(int, re.findall('[+-]?\d+', expression))
        a1, b1 = 0, 1
        for i in xrange(0, len(nums), 2):
            a2, b2 = nums[i], nums[i + 1]

            a1, b1 = a1 * b2 + a2 * b1, b1 * b2

            g = self.gcd(a1, b1)

            a1 /= g
            b1 /= g

        return '{}/{}'.format(a1, b1)

    def gcd(self, x, y):
        return x if y == 0 else self.gcd(y, x % y)
