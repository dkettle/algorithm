class LRUCache(object):
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.mp = {}
        self.li = []

    def put_key_to_tail(self, key):
        self.li.remove(key)
        self.li.append(key)

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.mp:
            self.put_key_to_tail(key)
            return self.mp[key]

        return -1

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if key in self.mp:
            self.put_key_to_tail(key)
            self.mp[key] = value
        else:
            self.li.append(key)
            if len(self.li) > self.capacity:
                del_key = self.li.pop(0)
                del self.mp[del_key]
        self.mp[key] = value
