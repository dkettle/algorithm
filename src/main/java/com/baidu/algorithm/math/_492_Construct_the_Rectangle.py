import math


class Solution(object):
    def constructRectangle(self, area):
        """
        :type area: int
        :rtype: List[int]
        """
        l = int(math.ceil(math.sqrt(area)))
        while area % l != 0:
            l += 1

        return [l, area / l]
