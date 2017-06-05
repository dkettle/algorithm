def searchMatrix(matrix, target):
    """
    :type matrix: List[List[int]]
    :type target: int
    :rtype: bool
    """
    if len(matrix) > 0 and len(matrix[0]) > 0:
        m, n = len(matrix), len(matrix[0])
        i, j = 0, n - 1
        while (i < m and j >= 0):
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] > target:
                j -= 1;
            else:
                i += 1;
    return False