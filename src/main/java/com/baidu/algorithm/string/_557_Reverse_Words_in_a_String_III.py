class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        split_arr = s.split(' ')
        reversed_arr = [x[::-1] for x in split_arr]

        return ' '.join(reversed_arr)
