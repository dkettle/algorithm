class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        res = ""
        while n:
            res = chr((n - 1) % 26 + ord('A')) + res
            n = (n - 1) / 26

        return res


if __name__ == '__main__':
    s = Solution()
    s.convertToTitle(26)
