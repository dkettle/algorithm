class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


import random


class Solution(object):
    def __init__(self, head):
        """
        @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node.
        :type head: ListNode
        """
        self.head = head

    def getRandom(self):
        """
        Returns a random node's value.
        :rtype: int
        """
        node, res = self.head, self.head
        cnt = 1

        while node.next:
            cnt += 1
            node = node.next
            rand = random.random()
            if rand < 1. / cnt:
                res = node

        return res.val
