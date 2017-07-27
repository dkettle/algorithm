class Solution(object):
    def findPoisonedDuration(self, timeSeries, duration):
        """
        :type timeSeries: List[int]
        :type duration: int
        :rtype: int
        """
        res, last = 0, 0
        for t in timeSeries:
            current = t + duration
            res += min(current - last, duration)
            last = current

        return res
