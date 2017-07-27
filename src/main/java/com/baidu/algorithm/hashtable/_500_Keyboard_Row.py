class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        if not words:
            return []

        dt = {}
        for x in 'qwertyuiop':
            dt[x] = 1

        for x in 'asdfghjkl':
            dt[x] = 2

        for x in 'zxcvbnm':
            dt[x] = 3

        res = []
        for word in words:
            if len(set([dt[x.lower()] for x in word])) <= 1:
                res.append(word)

        return res
