class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        while num >= 10:
            tmp = 0
            while num > 0:
                tmp += num % 10
                num /= 10
            num = tmp

        return num

    def addDigits1(self, num):
        """
        :type num: int
        :rtype: int
        数根一定是1~9其中的一个，因为不会有正数各位之和为0。
        """
        return 0 if num == 0 else 1 + (num - 1) % 9
