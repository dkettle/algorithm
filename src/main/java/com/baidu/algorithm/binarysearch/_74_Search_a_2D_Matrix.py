def searchMatrix(matrix, target):
    """
    :type matrix: List[List[int]]
    :type target: int
    :rtype: bool
    """
    if len(matrix) == 0 or len(matrix[0]) == 0:
        return False

    m, n = len(matrix), len(matrix[0])
    left, right = 0, m * n - 1

    while (left <= right):
        mid = (left + right) >> 1
        row, col = mid / n, mid % n

        if matrix[row][col] == target:
            return True
        elif matrix[row][col] < target:
            left = mid + 1
        else:
            right = mid - 1

    return False