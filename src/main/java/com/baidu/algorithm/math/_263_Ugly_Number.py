class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num > 0:
            while num % 2 == 0:
                num >>= 1
            while num % 3 == 0:
                num /= 3
            while num % 5 == 0:
                num /= 5

            return True if num == 1 else False

        return False