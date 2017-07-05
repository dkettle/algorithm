class MyQueue(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.lstack = []
        self.rstack = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: void
        """
        self.rstack.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if not self.lstack:
            while self.rstack:
                self.lstack.append(self.rstack.pop())

        return self.lstack.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if not self.lstack:
            while self.rstack:
                self.lstack.append(self.rstack.pop())

        return self.lstack[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return not self.lstack and not self.rstack
