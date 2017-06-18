class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        if not s:
            return []

        return self.dfs(s, wordDict, {})

    def dfs(self, s, words, mp):
        if s in mp:
            return mp[s]

        if not s:
            return [""]

        res = []
        for word in words:
            if s.startswith(word):
                sub_res = self.dfs(s[len(word):], words, mp)
                for x in sub_res:
                    res.append(word + ("" if not x else " ") + x)

        mp[s] = res
        return res
