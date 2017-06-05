def sortColors(nums):
    """
    :type nums: List[int]
    :rtype: void Do not return anything, modify nums in-place instead.
    """
    if len(nums) > 1:
        i, j, k = 0, len(nums) - 1, 0
        while (k <= j):
            if nums[k] == 0:
                if k > i:
                    nums[k], nums[i] = 1, 0
                k += 1
                i += 1
            elif nums[k] == 1:
                k += 1
            else:
                if k < j:
                    nums[k], nums[j] = nums[j], 2
                j -= 1
