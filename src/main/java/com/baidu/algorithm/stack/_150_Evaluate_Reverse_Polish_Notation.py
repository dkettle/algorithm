class Solution(object):
    def __init__(self):
        self.op = {
            '+': lambda y, x: x + y,
            '-': lambda y, x: x - y,
            '*': lambda y, x: x * y,
            '/': lambda y, x: int(float(x) / y)
        }

        def evalRPN(self, tokens):
            if not tokens:
                return 0

            stack = []
            for token in tokens:
                if token in self.op:
                    stack.append(self.op[token](stack.pop(), stack.pop()))
                else:
                    stack.append(int(token))

            return stack.pop()
