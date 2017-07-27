class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        if not num:
            return []

        res = []
        self.dfs(res, "", num, target, 0, 0, 0)

        return res

    def dfs(self, res, cur_res, num, target, pos, cur_val, last_val):
        if pos == len(num):
            if cur_val == target:
                res.append(cur_res)
            return

        for i in xrange(pos, len(num) + 1):
            if i > pos and num[pos] == '0':
                break

            tmp = num[pos:i + 1]
            val = int(tmp)
            if pos == 0:
                self.dfs(res, cur_res + num[pos:i + 1], num, target, i + 1, val, val)
            else:
                self.dfs(res, cur_res + '+' + tmp, num, target, i + 1, cur_val + val, val)
                self.dfs(res, cur_res + '-' + tmp, num, target, i + 1, cur_val - val, -val)
                self.dfs(res, cur_res + '*' + tmp, num, target, i + 1, cur_val - last_val + last_val * val, last_val * val)
