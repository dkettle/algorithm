from collections import deque

class MyStack(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.deque = deque()

    def push(self, x):
        """
        Push element x onto stack.
        :type x: int
        :rtype: void
        """
        self.deque.append(x)
        for _ in xrange(len(self.deque) - 1):
            self.deque.append(self.deque.popleft())


    def pop(self):
        """
        Removes the element on top of the stack and returns that element.
        :rtype: int
        """
        return self.deque.popleft()

    def top(self):
        """
        Get the top element.
        :rtype: int
        """
        return self.deque[0]


    def empty(self):
        """
        Returns whether the stack is empty.
        :rtype: bool
        """
        return len(self.deque) == 0