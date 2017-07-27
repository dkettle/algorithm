import itertools
import numpy as np


class Solution(object):
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        one_dim = sum(nums, [])

        if len(one_dim) != r * c:
            return nums

        return [one_dim[t * c: (t + 1) * c] for t in xrange(r)]

    def matrixReshape1(self, nums, r, c):

        flat = sum(nums, [])
        if len(flat) != r * c:
            return nums

        tuples = zip(*[iter(flat)] * c)
        return map(list, tuples)

    def matrixReshape2(self, nums, r, c):
        if r * c != len(nums) * len(nums[0]):
            return nums

        it = itertools.chain(*nums)

        return [list(itertools.islice(it, c)) for _ in xrange(r)]

    def matrixReshape3(self, nums, r, c):
        try:
            return np.reshape(nums, (r, c)).tolist()
        except:
            return nums
