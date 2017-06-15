class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        res = []
        self.dfs(res, [], s)

        return res

    def dfs(self, res, cur_res, s):
        if not s:
            res.append(cur_res)
        else:
            for i in xrange(len(s)):
                if self.valid_palindrome(s[:i + 1]):
                    self.dfs(res, cur_res + [s[:i + 1]], s[i + 1:])

    def valid_palindrome(self, s):
        return s == s[::-1]
