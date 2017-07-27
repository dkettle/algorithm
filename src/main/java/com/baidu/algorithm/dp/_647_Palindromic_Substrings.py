class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0

        n = len(s)
        dp = [[False] * n for _ in xrange(n)]

        for gap in xrange(n):
            for i in xrange(n - gap):
                dp[i][i + gap] = True if gap == 0 else \
                                 s[i] == s[i + gap] if gap == 1 else \
                                 s[i] == s[i + gap] and dp[i + 1][i + gap - 1]

        return sum(map(sum, dp))
