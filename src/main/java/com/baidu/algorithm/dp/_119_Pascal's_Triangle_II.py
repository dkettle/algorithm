class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        if rowIndex < 0:
            return []
        elif rowIndex == 0:
            return [1]
        else:
            last_res = [1]
            for i in range(0, rowIndex):
                cur_res = [1]
                for j in range(1, len(last_res)):
                    cur_res.append(last_res[j - 1] + last_res[j])
                cur_res.append(1)
                last_res = cur_res

            return last_res
