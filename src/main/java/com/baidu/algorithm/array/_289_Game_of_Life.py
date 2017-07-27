class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return

        m, n = len(board), len(board[0])
        for i in xrange(m):
            for j in xrange(n):
                live = self.count_live(i, j, board)
                if (board[i][j] & 1) and 2 <= live <= 3:
                    board[i][j] |= 2
                elif not (board[i][j] & 1) and live == 3:
                    board[i][j] |= 2
                elif (board[i][j] & 1) and live < 2:
                    board[i][j] &= 1
                elif (board[i][j] & 1) and live > 3:
                    board[i][j] &= 1

        for i in xrange(m):
            for j in xrange(n):
                board[i][j] >>= 1

    def count_live(self, x, y, board):
        m, n = len(board), len(board[0])
        res = 0
        for i in xrange(max(0, x - 1), min(m, x + 2)):
            for j in xrange(max(0, y - 1), min(n, y + 2)):
                if not (x == i and y == j):
                    res += board[i][j] & 1

        return res
