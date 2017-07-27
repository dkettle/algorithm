class PeekingIterator(object):
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        self.iter = iterator
        self.cache = None

    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        if not self.cache:
            self.cache = self.iter.next()
        return self.cache

    def next(self):
        """
        :rtype: int
        """
        if not self.cache:
            self.cache = self.iter.next()

        res = self.cache
        self.cache = None

        return res

    def hasNext(self):
        """
        :rtype: bool
        """
        if self.cache or self.iter.hasNext():
            return True
        return False
