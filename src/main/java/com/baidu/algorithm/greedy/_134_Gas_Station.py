class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        if not gas or not cost or len(gas) != len(cost):
            return -1

        remain = [x - y for x, y in zip(gas, cost)]

        if sum(remain) < 0:
            return -1

        total, pos = 0, 0
        for i in xrange(len(remain)):
            total += remain[i]
            if total < 0:
                total, pos = 0, i + 1

        return pos
