class Solution(object):
    def minCut(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s or len(s) < 2:
            return 0

        n = len(s)
        dp = [[False] * n for _ in xrange(n)]
        cut = [0] * n

        for i in xrange(n):
            min_val = i
            for j in xrange(i + 1):
                if s[i] == s[j] and (j + 1 > i - 1 or dp[j + 1][i - 1]):
                    dp[j][i] = True
                    min_val = 0 if j == 0 else min(min_val, cut[j - 1] + 1)
            cut[i] = min_val

        return cut[n - 1]


if __name__ == '__main__':
    s = Solution()
    s.minCut("abbab")
