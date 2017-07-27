class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        if not people:
            return []

        dt, height, res = {}, [], []
        for p in people:
            if p[0] not in dt:
                # dt[p[0]] = []
                height.append(p[0])

            # dt[p[0]].append(p[1])
            dt.setdefault(p[0], []).append(p[1])

        height.sort(reverse=True)

        for h in height:
            dt[h].sort()
            for p in dt[h]:
                res.insert(p, [h, p])

        return res
