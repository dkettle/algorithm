class TrieNode:
    def __init__(self):
        self.is_word = False
        self.child = collections.defaultdict(TrieNode)

class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()


    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        cur = self.root
        for letter in word:
            cur = cur.child[letter]

        cur.is_word = True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        cur = self.root
        for letter in word:
            cur = cur.child.get(letter)
            if cur is None:
                return False

        return cur.is_word

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        cur = self.root
        for letter in prefix:
            cur = cur.child.get(letter)
            if cur is None:
                return False

        return True