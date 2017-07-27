import math


class Solution(object):
    def largestPalindrome(self, n):
        """
        :type n: int
        :rtype: int
        """
        num = pow(10, n) - 1
        max_val = pow(num, 2)
        half, palindrome = max_val / pow(10, n), 0

        while True:
            palindrome = self.create_palindrome(half)
            half -= 1

            if palindrome > max_val:
                continue

            for x in xrange(num, int(math.sqrt(palindrome)), -1):
                if palindrome % x == 0:
                    return palindrome % 1337

            if half == 0:
                palindrome = 9
                break

        return palindrome % 1337

    @staticmethod
    def create_palindrome(x):
        return int(str(x) + str(x)[::-1])


import time

if __name__ == '__main__':
    t1 = time.time()

    s = Solution()
    for i in xrange(8):
        print s.largestPalindrome(i + 1)

    print time.time() - t1
