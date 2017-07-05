class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        ugly_num = [1]
        two_index, three_index, five_index = 0, 0, 0

        for _ in xrange(n - 1):
            two_num = 2 * ugly_num[two_index]
            three_num = 3 * ugly_num[three_index]
            five_num = 5 * ugly_num[five_index]

            min_val = min(two_num, three_num, five_num)
            ugly_num.append(min_val)

            if min_val == two_num:
                two_index += 1
            if min_val == three_num:
                three_index += 1
            if min_val == five_num:
                five_index += 1

        return ugly_num[-1]
