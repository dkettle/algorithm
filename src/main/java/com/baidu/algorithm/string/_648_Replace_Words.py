class Solution(object):
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        dict.sort(key=len)

        sent = sentence.split()
        for i, s in enumerate(sent):
            for r in dict:
                if s.startswith(r):
                    sent[i] = r
                    break

        return ' '.join(sent)
