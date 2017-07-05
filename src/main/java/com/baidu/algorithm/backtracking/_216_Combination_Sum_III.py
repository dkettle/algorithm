class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        res = []
        self.dfs(res, [], k, 9, 0, n)

        return res

    def dfs(self, res, cur_res, k, cur, cur_sum, n):
        if k == 0:
            if cur_sum == n:
                res.append(cur_res[:])
        elif cur_sum >= n or cur == 0:
            return
        else:
            self.dfs(res, cur_res, k, cur - 1, cur_sum, n)

            cur_res.append(cur)
            self.dfs(res, cur_res, k - 1, cur - 1, cur_sum + cur, n)
            cur_res.pop()

