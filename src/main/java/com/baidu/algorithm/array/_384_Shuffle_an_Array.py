import random


class Solution(object):
    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.nums = nums

    def reset(self):
        """
        Resets the array to its original configuration and return it.
        :rtype: List[int]
        """
        return self.nums

    def shuffle(self):
        """
        Returns a random shuffling of the array.
        :rtype: List[int]
        """
        shuffle = self.nums[:]

        for x in xrange(len(shuffle), 0, -1):
            rand = random.randrange(0, x)
            shuffle[x - 1], shuffle[rand] = shuffle[rand], shuffle[x - 1]

        return shuffle
