class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0

        res = 0
        for x in s:
            res = res * 26 + ord(x) - ord('A') + 1

        return res
