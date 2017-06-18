class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        if not s:
            return True

        n = len(s)
        dp = [True]
        dp.extend([False] * n)

        for i in xrange(1, n + 1):
            for word in wordDict:
                j = i - len(word)
                if j >= 0 and dp[j] and word == s[j:i]:
                    dp[i] = True
                    break

        return dp[-1]

