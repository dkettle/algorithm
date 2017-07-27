class Solution(object):
    def fizzBuzz(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        if n < 1:
            return []

        return [('FizzBuzz' if x % 15 == 0 else 'Fizz' if x % 3 == 0 else 'Buzz' if x % 5 == 0 else str(x))
                for x in xrange(1, n + 1)]

    def fizzBuzz1(self, n):
        return ['Fizz' * (not x % 3) + 'Buzz' * (not x % 5) or str(x) for x in xrange(1, n + 1)]


if __name__ == '__main__':
    s = Solution()
    print s.fizzBuzz(15)
