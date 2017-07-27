class Solution(object):
    def findRestaurant(self, list1, list2):
        """
        :type list1: List[str]
        :type list2: List[str]
        :rtype: List[str]
        """
        d1 = {word: index for index, word in enumerate(list1)}
        d2 = {word: index for index, word in enumerate(list2)}

        min_sum = 0x7fffffff
        res = []

        for word in d1:
            if word in d2:
                index = d1.get(word) + d2.get(word)
                if index < min_sum:
                    min_sum = index
                    res = [word]
                elif index == min_sum:
                    res.append(word)

        return res
