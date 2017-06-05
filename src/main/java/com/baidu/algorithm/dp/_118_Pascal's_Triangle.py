class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        if numRows < 1:
            return []
        elif numRows == 1:
            return [[1]]

        last_res = [1]
        res = []
        res.append(last_res)

        for i in range(2, numRows + 1):
            cur_res = [1]

            for j in range(1, len(last_res)):
                cur_res.append(last_res[j - 1] + last_res[j])

            cur_res.append(1)
            last_res = cur_res

            res.append(last_res)

        return res
