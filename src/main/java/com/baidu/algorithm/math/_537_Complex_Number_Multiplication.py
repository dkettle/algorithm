class Solution(object):
    def complexNumberMultiply(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        a1, b1 = map(int, a[:-1].split('+'))
        a2, b2 = map(int, b[:-1].split('+'))

        return '%d+%di' % (a1 * a2 - b1 * b2, a1 * b2 + a2 * b1)
