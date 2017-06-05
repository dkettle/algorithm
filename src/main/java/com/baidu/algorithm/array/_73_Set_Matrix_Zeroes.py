# encoding:utf8

def setZeroes(matrix):
    """
    :type matrix: List[List[int]]
    :rtype: void Do not return anything, modify matrix in-place instead.
    """
    row_flag, col_flag = False, False
    m, n = len(matrix), len(matrix[0])

    for i in range(m):
        for j in range(n):
            if matrix[i][j] == 0:
                if i == 0 or j == 0:
                    if i == 0:
                        row_flag = True
                    if j == 0:
                        col_flag = True
                else:
                    matrix[i][0] = matrix[0][j] = 0

    for i in range(1, m):
        for j in range(1, n):
            if matrix[i][0] == 0 or matrix[0][j] == 0:
                matrix[i][j] = 0

    if row_flag:
        for i in range(n):
            matrix[0][i] = 0

    if col_flag:
        for i in range(m):
            matrix[i][0] = 0


if __name__ == '__main__':
    mat = [[1, 2], [3, 0]]
    setZeroes(mat)

    print mat
