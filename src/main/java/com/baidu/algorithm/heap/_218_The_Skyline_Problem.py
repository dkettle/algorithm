import heapq


class Line(object):
    def __init__(self, val):
        self.val = val

    def __cmp__(self, other):
        return cmp(self.val[0], other.val[0]) or -cmp(self.val[1], other.val[1])


class PriorityQueue(object):
    def __init__(self):
        self.heap = []

    def push(self, val):
        heapq.heappush(self.heap, val)

    def peek(self):
        return self.heap[0]

    def remove(self, val):
        index = self.heap.index(val)

        while index > 0:
            up = (index + 1) / 2 - 1
            self.heap[index] = self.heap[up]
            index = up

        heapq.heappop(self.heap)

    def pop(self):
        return heapq.heappop(self.heap)

    def size(self):
        return len(self.heap)


class Solution(object):
    def getSkyline(self, buildings):
        """
        :type buildings: List[List[int]]
        :rtype: List[List[int]]
        """
        line_pq = PriorityQueue()
        for x, y, z in buildings:
            line_pq.push(Line((x, z)))
            line_pq.push(Line((y, -z)))

        height_pq = PriorityQueue()
        height_pq.push(0)

        res, prev, cur = [], 0, 0
        while line_pq.size() > 0:
            x, h = line_pq.pop().val
            # left line
            if h > 0:
                height_pq.push(-h)  # trick: push minus to peek max val
            # right line
            else:
                height_pq.remove(h)

            cur = height_pq.peek()
            if cur != prev:
                res.append([x, -cur])

            prev = cur

        return res


if __name__ == '__main__':
    s = Solution()
    s.getSkyline([[2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8]])
