class Solution(object):
    def findLUSlength(self, strs):
        """
        :type strs: List[str]
        :rtype: int
        """
        strs.sort(key=len, reverse=True)

        for i, s1 in enumerate(strs):
            if all(not self.sub_seq(s1, s2) for j, s2 in enumerate(strs) if j != i):
                return len(s1)
        return -1

    # s1 is sub seq of s2 ?
    def sub_seq(self, s1, s2):

        if len(s1) > len(s2):
            return False

        i = 0
        for c in s2:
            if i < len(s1) and c == s1[i]:
                i += 1

        return i == len(s1)
