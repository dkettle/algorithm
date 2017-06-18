class Solution(object):
    def fractionToDecimal(self, numerator, denominator):
        """
        :type numerator: int
        :type denominator: int
        :rtype: str
        """
        sign = "-" if ((numerator ^ denominator) >> 31) else ""
        numerator, denominator = abs(numerator), abs(denominator)

        int_part, numerator = divmod(numerator, denominator)

        if numerator == 0:
            return "0" if not int_part else sign + str(int_part)

        return sign + str(int_part) + "." + str(self.helper(numerator, denominator))

    def helper(self, numerator, denominator):
        index = 0
        mp = {numerator: index}
        li = []
        while numerator:
            numerator *= 10
            li.append(str(numerator / denominator))

            numerator %= denominator
            if numerator in mp:
                begin = mp.get(numerator)
                li.insert(begin, '(')
                li.append(')')
                break

            index += 1
            mp[numerator] = index

        return "".join(li)
