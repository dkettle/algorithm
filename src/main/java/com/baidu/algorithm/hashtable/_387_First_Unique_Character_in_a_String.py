class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        dt = {}
        for i, c in enumerate(s):
            dt.setdefault(c, []).append(i)

        for c in s:
            if len(dt[c]) == 1:
                return dt[c][0]

        return -1

    def firstUniqChar1(self, s):
        """
        :type s: str
        :rtype: int
        """
        cnt = [0] * 26
        for c in s:
            cnt[ord(c) - ord('a')] += 1

        for i, c in enumerate(s):
            if cnt[ord(c) - ord('a')] == 1:
                return i

        return -1
