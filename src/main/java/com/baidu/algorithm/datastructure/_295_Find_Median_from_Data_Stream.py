import heapq


class MedianFinder(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.left_heap = []  # max heap
        self.right_heap = []  # min heap
        self.left_sz, self.right_sz = 0, 0

    def addNum(self, num):
        """
        :type num: int
        :rtype: void
        """
        heapq.heappush(self.right_heap, num)
        heapq.heappush(self.left_heap, -heapq.heappop(self.right_heap))
        self.left_sz += 1

        if self.right_sz < self.left_sz:
            heapq.heappush(self.right_heap, -heapq.heappop(self.left_heap))
            self.left_sz -= 1
            self.right_sz += 1

    def findMedian(self):
        """
        :rtype: float
        """
        if self.left_sz < self.right_sz:
            return self.right_heap[0]
        else:
            return (-self.left_heap[0] + self.right_heap[0]) / 2.0


if __name__ == '__main__':
    s = MedianFinder()
    s.addNum(-1)
    print s.findMedian()
    s.addNum(-2)
    print s.findMedian()
    s.addNum(-3)
    print s.findMedian()
    s.addNum(-4)
    print s.findMedian()
    s.addNum(-5)
    print s.findMedian()
