class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0

        m, n, res = len(grid), len(grid[0]), 0
        for i in xrange(m):
            for j in xrange(n):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j)
                    res += 1

        return res

    def dfs(self, grid, x, y):
        if 0 <= x < len(grid) and 0 <= y < len(grid[0]) and grid[x][y] == '1':
            grid[x][y] = '2'
            self.dfs(grid, x - 1, y)
            self.dfs(grid, x + 1, y)
            self.dfs(grid, x, y - 1)
            self.dfs(grid, x, y + 1)

