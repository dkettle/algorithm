class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        content_path = {}
        for path in paths:
            files = path.split()
            for f in files[1:]:
                name, content = f.split('(')
                content_path.setdefault(content[:-1], []).append(files[0] + '/' + name)

        res = []
        for _, path in content_path.iteritems():
            if len(path) > 1:
                res.append(path)

        return res
