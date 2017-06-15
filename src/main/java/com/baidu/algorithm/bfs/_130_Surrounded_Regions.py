class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return

        m, n = len(board), len(board[0])
        st = []
        for i in xrange(m):
            if board[i][0] == 'O':
                st.append((i, 0))
            if board[i][n - 1] == 'O':
                st.append((i, n - 1))
        for j in xrange(n):
            if board[0][j] == 'O':
                st.append((0, j))
            if board[m - 1][j] == 'O':
                st.append((m - 1, j))

        self.bfs(board, st, m, n)

        for i in xrange(m):
            for j in xrange(n):
                board[i][j] = 'O' if board[i][j] == 'Z' else 'X'

    def bfs(self, board, st, m, n):
        while st:
            i, j = st.pop()
            board[i][j] = 'Z'
            for mi, mj in ((-1, 0), (1, 0), (0, 1), (0, -1)):
                x, y = i + mi, j + mj
                if 0 <= x < m and 0 <= y < n and board[x][y] == 'O':
                    st.append((x, y))


if __name__ == '__main__':
    board = [list("XXXX"), list("XOOX"), list("XXOX"), list("XOXX")]
    s = Solution()
    s.solve(board)
