class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        if not flowerbed:
            return False

        can_place, m = 0, len(flowerbed)
        for index, placed in enumerate(flowerbed):
            if not placed and (index == 0 or not flowerbed[index - 1]) and (index == m - 1 or not flowerbed[index + 1]):
                flowerbed[index] = 1
                can_place += 1

        return can_place >= n


if __name__ == '__main__':
    s = Solution()
    s.canPlaceFlowers([1, 0, 0, 0, 1], 1)
