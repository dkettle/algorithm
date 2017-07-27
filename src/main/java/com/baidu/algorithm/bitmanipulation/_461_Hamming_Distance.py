class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        return self.count_one(x ^ y)

    def count_one(self, x):
        shift, res = 0, 0
        while shift < 32:
            if x & (1 << shift):
                res += 1
            shift += 1

        return res

    def count_one1(self, x):
        x = (x & 0x55555555) + ((x >> 1) & 0x55555555)
        x = (x & 0x33333333) + ((x >> 2) & 0x33333333)
        x = (x & 0x0f0f0f0f) + ((x >> 4) & 0x0f0f0f0f)
        x = (x & 0x00ff00ff) + ((x >> 8) & 0x00ff00ff)
        x = (x & 0x0000ffff) + ((x >> 16) & 0x0000ffff)

        return x
